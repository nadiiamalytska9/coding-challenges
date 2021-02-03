package algorithms.book;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LruCacheTest {

    private LruCache<Integer, String> lruCache;

    @Before
    public void createLreCash() {
        lruCache = LruCache.newInstant(5);
        lruCache.put(1, "one");
        lruCache.put(2, "two");
        lruCache.put(3, "three");
        lruCache.put(4, "four");
        lruCache.put(5, "five");
    }

    @Test
    public void shouldUseAccessOrder() {
        Set<Integer> keys = lruCache.keySet();
        lruCache.get(3);
        lruCache.get(1);
        assertEquals("[2, 4, 5, 3, 1]", keys.toString());
    }

    @Test
    public void shouldRemoveEldestEntryAfterInsertion() {
        Set<Integer> keys = lruCache.keySet();
        assertEquals("[1, 2, 3, 4, 5]", keys.toString());
        lruCache.get(1);
        lruCache.get(2);

        lruCache.put(7, "seven");
        lruCache.put(8, "eight");
        assertEquals("[5, 1, 2, 7, 8]", keys.toString());
    }
}
