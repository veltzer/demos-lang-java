package effectivejava.exercises;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

@SuppressWarnings("serial")
public final class Point implements Serializable, Cloneable, Comparable<Point> {
	private final int x;
	private final int y;

	private static final Point ZERO = new Point(0, 0);

	private Point(int ix, int iy) {
		x = ix;
		y = iy;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Point)) {
			return false;
		}
		Point point = (Point) o;
		return x == point.x && y == point.y;

	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + x;
		result = 31 * result + y;
		return result;
	}

	//FACTORY METHODS
	public static Point point(int x, int y) {
		return isZero(x, y) ? ZERO : new Point(x, y);
	}

	public static Point vertical(int x) {
		return point(x, 0);
	}

	public static Point horizontal(int y) {
		return point(0, y);
	}

	public static Point zero() {
		return ZERO;
	}

	/*
	private static boolean isZero(int t) {
		return t == 0;
	}
	*/

	private static boolean isZero(int x, int y) {
		return x == 0 && y == 0;
	}

	private Object readResolve() {
		return equals(ZERO) ? ZERO : this;
	}

	@Override public String toString() {
		return new StringBuilder().
						 append('[').
								append(x).
											append(',').
								 append(y).
						 append(']').toString();
	}
	@Override public Point clone() {
		try {
			return (Point) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e); //this will never happen
		}
	}

	@Override
	public int compareTo(Point o) {
		return Double.compare(norm(), o.norm());
	}

	public double norm() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	public static void main(String[] args) {
		Set<Point> h = Collections.newSetFromMap(
						new IdentityHashMap<Point, Boolean>()); //new HashSet<Point>();
		Point p = Point.point(1, 2);
		h.add(p);
		System.out.println("Contains=" + h.contains(p.clone()));

		List<Point> l = Arrays.asList(Point.point(1, 2), Point.point(1, 1), Point.point(3, 2));
		Collections.sort(l);
		System.out.println(l);
	}
}
