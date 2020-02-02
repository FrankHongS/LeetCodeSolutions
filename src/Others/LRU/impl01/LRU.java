package Others.LRU.impl01;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Frank_Hon on 2019-09-01 18:20.
 * E-mail: frank_hon@foxmail.com
 */
public class LRU<K, V> {

    private static final float HASH_LOAD_FACTORY = 0.75f;
    private LinkedHashMap<K, V> map;

    public LRU(int cacheSize) {
        int capacity = (int) Math.ceil(cacheSize / HASH_LOAD_FACTORY) + 1;
        this.map = new LinkedHashMap<K, V>(capacity, HASH_LOAD_FACTORY, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > cacheSize;
            }
        };
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized void clear() {
        map.clear();
    }

    public synchronized int usedSize() {
        return map.size();
    }

    public void print() {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ,");
        }
        System.out.println();
    }
}
