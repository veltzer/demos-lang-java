package exercises.generics;

import java.util.HashMap;
import java.util.Map;

public class Cache<K, V> {
	private int capacity;
	private Map<K, V> map;

	/** Creates a new instance of Cache */
	public Cache(int icapacity) {
		capacity = icapacity;
		map = new HashMap<K, V>(capacity);
	}

	public void offer(K k, V v) {
		if (map.containsKey(k) || map.size() < capacity) {
			map.put(k, v);
		}
	}

	public V get(K k) {
		return map.get(k);
	}

	public V invalidate(K k) {
		return map.remove(k);
	}

	public static void main(String[] args) {
		Cache<Integer, String> c = new Cache<Integer, String>(3);
		c.offer(Integer.valueOf(1), "*One*");
		c.offer(2, "*Two*");
		c.offer(3, "*Three*");
		c.offer(4, "*Four*");

		for (int i = 0; i < 5; i++) {
			System.out.format("%d:%s\n", i, c.get(i));
		}
	}
}
