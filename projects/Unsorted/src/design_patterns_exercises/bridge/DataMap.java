package design_patterns_exercises.bridge;

public interface DataMap
{
	void put(Object key, Object value);

	Object get(Object key);

	boolean keyExists(Object key);
}
