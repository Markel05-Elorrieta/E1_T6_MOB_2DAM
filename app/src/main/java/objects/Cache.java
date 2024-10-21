package objects;

import java.util.HashMap;

public class Cache {
    private HashMap<String, Integer> cache = new HashMap<String, Integer>();

    public void put(String key, Integer value) {
        cache.put(key, value);
    }

    public Integer get(String key) {
        return cache.get(key);
    }
}
