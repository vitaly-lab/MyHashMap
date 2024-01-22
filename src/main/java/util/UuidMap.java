package util;

import java.util.*;

public class UuidMap implements Map<UUID, String> {
    private static final float LOAD_FACTOR = 0.75f;
    private int size;
    private int buckets = 16;
    LinkedList<Entry>[] table;

    public UuidMap() {
        table = new LinkedList[buckets];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();

            if (size * 1.0 / buckets > LOAD_FACTOR) {
                int newBuckets = buckets * 2;
                LinkedList<Entry>[] newTable = Arrays.copyOf(table, newBuckets);
                table = newTable;
            }
        }
    }

    class Entry {
        UUID key;
        String value;

        public Entry(UUID key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public String put(UUID key, String value) {
        Entry newEntry = new Entry(key, value);
        int bucketIndex = getIndexBucket(key);
        LinkedList<Entry> matchingBucket = table[bucketIndex];
        for (Entry entry : matchingBucket) {
            if (entry.key.hashCode() == key.hashCode() &&
                    entry.key.equals(key)) {
                entry.value = value;
                return value;
            }
        }
        matchingBucket.add(newEntry);
        size++;
        return value;
    }

    @Override
    public String get(Object key) {
        int bucketIndex = getIndexBucket(key);
        LinkedList<Entry> matchingBucket = table[bucketIndex];
        String newValue = null;
        for (Entry entry : matchingBucket) {
            if (entry.key.hashCode() == key.hashCode() &&
                    entry.key.equals(key)) {
                newValue = entry.value;
            }
        }
        return newValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int bucketIndex = getIndexBucket(key);
        LinkedList<Entry> matchingBucket = table[bucketIndex];
        boolean tmpBoolen = false;
        for (Entry entry : matchingBucket) {
            if (entry.key.hashCode() == key.hashCode() &&
                    entry.key.equals(key)) {
                tmpBoolen = true;
            }
        }
        return tmpBoolen;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean newValue = false;
        for (LinkedList<Entry> list : table) {
            if (list != null) {
                for (Entry entry : list) {
                    if (entry.value.equals(value)) {
                        newValue = true;
                    }
                }
            }
        }
        return newValue;
    }

    @Override
    public String remove(Object key) {
        int bucketIndex = getIndexBucket(key);
        LinkedList<Entry> matchingBucket = table[bucketIndex];
        Iterator<Entry> iterator = matchingBucket.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.key.hashCode() == key.hashCode() &&
                    entry.key.equals(key)) {
                iterator.remove();
                size--;
                return null;
            }
        }
        return null;

    }

    @Override
    public void putAll(Map<? extends UUID, ? extends String> m) {
        for (Map.Entry<? extends UUID, ? extends String> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                table[i].clear();
            }
        }
        size = 0;
    }

    @Override
    public Set<UUID> keySet() {
        Set<UUID> keys = new HashSet<>();
        for (LinkedList<Entry> list : table) {
            if (list != null) {
                for (Entry entry : list) {
                    keys.add(entry.key);
                }
            }
        }
        return keys;
    }

    @Override
    public Collection<String> values() {
        List<String> valuesList = new ArrayList<>();
        for (LinkedList<Entry> list : table) {
            if (list != null) {
                for (Entry entry : list) {
                    valuesList.add(entry.value);
                }
            }
        }
        return valuesList;
    }

    @Override
    public Set<Map.Entry<UUID, String>> entrySet() {

        Set<Map.Entry<UUID, String>> entrySet = new HashSet<>();
        for (LinkedList<Entry> list : table) {
            if (list != null) {
                for (Entry entry : list) {
                    Map.Entry<UUID, String> mapEntry = new AbstractMap.SimpleEntry<>(entry.key, entry.value);
                    entrySet.add(mapEntry);
                }
            }
        }
        return entrySet;

    }

    private int getIndexBucket(Object o) {
        int hashCode = o.hashCode();
        return (hashCode & Integer.MAX_VALUE) % buckets;
    }
}
