package objects;

import java.util.HashMap;

public class Cache {
    private HashMap<String, String> cache = new HashMap<String, String>();

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }
}
