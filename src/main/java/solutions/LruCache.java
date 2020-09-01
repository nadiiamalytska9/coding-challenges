package solutions;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> extends LinkedHashMap<K, V> {
    private int MAX_SIZE;

    private LruCache(int size) {
        super(size + 1, 1.1f, true);
        this.MAX_SIZE = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_SIZE;
    }

    public static <K, V> LruCache<K, V> newInstant(int size) {
        return new LruCache<>(size);
    }
}
