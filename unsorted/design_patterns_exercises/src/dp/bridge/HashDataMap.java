/*
 * Created on Jan 29, 2006
 */
package dp.bridge;

import java.util.HashMap;
import java.util.Map;

public class HashDataMap implements DataMap
{
	private Map<Object,Object> dataMap;

	public HashDataMap()
	{
		super();
		dataMap = new HashMap<Object,Object>();
	}

	public void put(Object key, Object value)
	{
		dataMap.put(key, value);
	}

	public Object get(Object key)
	{
		return dataMap.get(key);
	}

	public boolean keyExists(Object key)
	{
		return dataMap.containsKey(key);
	}

}
