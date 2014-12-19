package core.threads;

import java.text.ParseException;
import java.util.StringTokenizer;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.LongByReference;
import net.jcip.annotations.Immutable;

/**
 * Library for lower multi core level work (affinity, core number query and more)
 * Taken from:
 * http://trac.assembla.com/Behemoth/browser/Tests/JAVA/test/src/main/java/test/threads/ThreadAffinity.java
 */
abstract class ThreadAffinity {

	private static final Core[] CORES;

	static {
		final int coresCount = Runtime.getRuntime().availableProcessors();
		CORES = new Core[coresCount];

		for (int i = 0; i < CORES.length; i++) {
			CORES[i] = new Core(i);
		}
	}

	@Immutable
	public static final class Core {
		private final int sequence;

		public Core(final int isequence) {
			if (isequence > Integer.SIZE) {
				throw new IllegalStateException("Too many cores (" + isequence + ") for integer mask");
			}
			sequence = isequence;
		}

		public int sequence() {
			return sequence;
		}

		public void attachTo() throws Exception {
			final long mask = mask();
			setCurrentThreadAffinityMask(mask);
		}

		public void attach(final Thread thread) throws Exception {
			//final long mask = mask();
			//fixme: it does not work for now!
			//setThreadAffinityMask( thread.getId(), mask );
		}

		private int mask() {
			return 1 << sequence;
		}

		@Override
		public String toString() {
			return String.format("Core[#%d]", sequence());
		}
	}

	public static void setCurrentThreadAffinityMask(final long mask) {
		final CLibrary lib = CLibrary.INSTANCE;
		final int cpuMaskSize = Long.SIZE / 8;
		try {
			final int ret = lib.sched_setaffinity(0, cpuMaskSize, new LongByReference(mask));
			if (ret < 0) {
				String errString = "sched_setaffinity( 0, (" + cpuMaskSize + ") , &(" + mask + ") ) return " + ret;
				throw new RuntimeException(errString);
			}
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	public static void setThreadAffinityMask(final long threadID, final long mask) {
		final CLibrary lib = CLibrary.INSTANCE;
		final int cpuMaskSize = Long.SIZE / 8;
		try {
			final int ret = lib.sched_setaffinity(
				(int) threadID,
				cpuMaskSize,
				new LongByReference(mask)
			);
			if (ret < 0) {
				String errString = "sched_setaffinity( " + threadID + ", (" + cpuMaskSize + ") , &(" + mask + ") ) return " + ret;
				throw new RuntimeException(errString);
			}
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	public static Core[] cores() {
		return CORES.clone();
	}

	public static Core currentCore() {
		final int cpuSequence = CLibrary.INSTANCE.sched_getcpu();
		return CORES[cpuSequence];
	}

	public static void nice(final int increment) {
		final CLibrary lib = CLibrary.INSTANCE;
		try {
			final int ret = lib.nice(increment);
			if (ret < 0) {
				String errString = "nice( " + increment + " ) return " + ret;
				throw new RuntimeException(errString);
			}
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private interface CLibrary extends Library {
		CLibrary INSTANCE = (CLibrary) Native.loadLibrary("c", CLibrary.class);
		int nice(final int increment);
		int sched_setaffinity(final int pid, final int cpusetsize, final PointerType cpuset);
		int sched_getcpu();
	}

	public static void main(final String[] args) {
		final Core currentCore = currentCore();
		System.out.printf("currentCore() -> %s\n", currentCore);

		final int niceRet = CLibrary.INSTANCE.nice(-20);
		System.out.printf("nice -> %d\n", niceRet);

		for (final Core core : cores()) {
			new Thread() {
				@Override
				public void run() {
					try {
						core.attachTo();
						System.out.printf("currentCore() -> %s\n", currentCore());
						for (int i = 0; i < Integer.MAX_VALUE; i++) {
							i--;
						}
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
			} .start();
		}
	}

	public static int[] parseCoresIndexes(final String str, final int[] defaults) {
		final StringTokenizer stok = new StringTokenizer(str, ",");
		final int size = stok.countTokens();
		if (size == 0) {
			return defaults;
		}

		final int maxIndex = Runtime.getRuntime().availableProcessors() - 1;
		final int[] indexes = new int[size];
		for (int i = 0; stok.hasMoreTokens(); i++) {
			final String token = stok.nextToken();
			final int index;
			try {
				index = Integer.parseInt(token);
			} catch (NumberFormatException e1) {
				ParseException e = new ParseException("Can't parse [" + i + "]='" + token + "' as Integer", i);
				throw new RuntimeException(e);
			}
			if (index > maxIndex || index < 0) {
				ParseException e = new ParseException("Core index[" + i + "]=" + index + " is out of bounds [0," + maxIndex + "]", i);
				throw new RuntimeException(e);
			}
			indexes[i] = index;
		}
		return indexes;
	}

	public static Core[] parseCores(final String str, final int[] defaults) {
		final int[] indexes = parseCoresIndexes(str, defaults);
		final Core[] myCores = new Core[indexes.length];
		for (int i = 0; i < myCores.length; i++) {
			myCores[i] = cores()[indexes[i]];
		}
		return myCores;
	}
}
