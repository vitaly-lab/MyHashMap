package util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertTrue;


public class UuidMapTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testPut() {
        Map<UUID, String> UuidMap = new UuidMap();
        UUID key1 = UUID.randomUUID();
        String value1 = "Value1";
        String result1 = UuidMap.put(key1, value1);

        assertEquals(value1, result1);
        assertEquals(1, UuidMap.size());
        assertTrue(UuidMap.containsKey(key1));

        String value2 = "Value2";
        String result2 = UuidMap.put(key1, value2);

        assertEquals(value2, result2);
        assertEquals(1, UuidMap.size());
        assertEquals(value2, UuidMap.get(key1));
    }

    @Test
    public void testSize() {
        Map<UUID, String> UuidMap = new UuidMap();
        assertEquals(0, UuidMap.size());

        UUID key1 = UUID.randomUUID();
        String value1 = "Value1";
        UuidMap.put(key1, value1);
        assertEquals(1, UuidMap.size());

        UUID key2 = UUID.randomUUID();
        String value2 = "Value2";
        UuidMap.put(key2, value2);
        assertEquals(2, UuidMap.size());

        UuidMap.remove(key1);
        assertEquals(1, UuidMap.size());
    }

    @Test
    public void testIsEmpty() {
        Map<UUID, String> UuidMap = new UuidMap();
        assertTrue(UuidMap.isEmpty());

        UUID key = UUID.randomUUID();
        String value = "Value";
        UuidMap.put(key, value);
        assertFalse(UuidMap.isEmpty());

        UuidMap.remove(key);
        assertTrue(UuidMap.isEmpty());
    }

    @Test
    public void testContainsKey() {
        Map<UUID, String> UuidMap = new UuidMap();
        assertFalse(UuidMap.containsKey(UUID.randomUUID()));

        UUID key = UUID.randomUUID();
        String value = "Value";
        UuidMap.put(key, value);
        assertTrue(UuidMap.containsKey(key));
        assertFalse(UuidMap.containsKey(UUID.randomUUID()));

        UuidMap.remove(key);
        assertFalse(UuidMap.containsKey(key));
    }

    @Test
    public void testContainsValue() {
        Map<UUID, String> UuidMap = new UuidMap();
        assertFalse(UuidMap.containsValue("Value"));

        UUID key = UUID.randomUUID();
        String value = "Value";
        UuidMap.put(key, value);
        assertTrue(UuidMap.containsValue(value));
        assertFalse(UuidMap.containsValue("NonExistentValue"));

        String updatedValue = "UpdatedValue";
        UuidMap.put(key, updatedValue);
        assertTrue(UuidMap.containsValue(updatedValue));

        UuidMap.remove(key);
        assertFalse(UuidMap.containsValue(updatedValue));
    }

    @Test
    public void testRemove() {
        Map<UUID, String> UuidMap = new UuidMap();
        UuidMap.remove(UUID.randomUUID());

        UUID key = UUID.randomUUID();
        String value = "Value";
        UuidMap.put(key, value);
        UuidMap.remove(key);

        assertFalse(UuidMap.containsKey(key));
        assertEquals(0, UuidMap.size());

        UuidMap.remove(UUID.randomUUID());
    }

    @Test
    public void testPutAll() {
        Map<UUID, String> UuidMap = new UuidMap();
        Map<UUID, String> otherMap = new HashMap<>();
        UUID key1 = UUID.randomUUID();
        UUID key2 = UUID.randomUUID();
        String value1 = "Value1";
        String value2 = "Value2";
        otherMap.put(key1, value1);
        otherMap.put(key2, value2);

        UuidMap.putAll(otherMap);

        assertTrue(UuidMap.containsKey(key1));
        assertTrue(UuidMap.containsKey(key2));
        assertEquals(value1, UuidMap.get(key1));
        assertEquals(value2, UuidMap.get(key2));
        assertEquals(2, UuidMap.size());

        UUID key3 = UUID.randomUUID();
        String value3 = "Value3";
        otherMap.put(key3, value3);

        UuidMap.putAll(otherMap);

        assertTrue(UuidMap.containsKey(key1));
        assertTrue(UuidMap.containsKey(key2));
        assertTrue(UuidMap.containsKey(key3));
        assertEquals(value1, UuidMap.get(key1));
        assertEquals(value2, UuidMap.get(key2));
        assertEquals(value3, UuidMap.get(key3));
        assertEquals(3, UuidMap.size());
    }

    @Test
    public void testClear() {
        Map<UUID, String> UuidMap = new UuidMap();
        UUID key1 = UUID.randomUUID();
        String value1 = "Value1";
        UuidMap.put(key1, value1);

        UUID key2 = UUID.randomUUID();
        String value2 = "Value2";
        UuidMap.put(key2, value2);

        assertFalse(UuidMap.isEmpty());
        assertTrue(UuidMap.containsKey(key1));
        assertTrue(UuidMap.containsKey(key2));

        UuidMap.clear();

        assertTrue(UuidMap.isEmpty());
        assertFalse(UuidMap.containsKey(key1));
        assertFalse(UuidMap.containsKey(key2));
        assertEquals(0, UuidMap.size());
    }

    @Test
    public void testKeySet() {
        Map<UUID, String> UuidMap = new UuidMap();

        UUID key1 = UUID.randomUUID();
        String value1 = "Value1";
        UuidMap.put(key1, value1);

        UUID key2 = UUID.randomUUID();
        String value2 = "Value2";
        UuidMap.put(key2, value2);

        Set<UUID> keySet = UuidMap.keySet();

        assertTrue(keySet.contains(key1));
        assertTrue(keySet.contains(key2));
    }

    @Test
    public void testValues() {
        Map<UUID, String> UuidMap = new UuidMap();
        UUID key1 = UUID.randomUUID();
        String value1 = "Value1";
        UuidMap.put(key1, value1);

        UUID key2 = UUID.randomUUID();
        String value2 = "Value2";
        UuidMap.put(key2, value2);

        Collection<String> valuesList = UuidMap.values();

        assertTrue(valuesList.contains(value1));
        assertTrue(valuesList.contains(value2));
    }

    @Test
    public void testEntrySet() {
        Map<UUID, String> UuidMap = new UuidMap();
        UUID key1 = UUID.randomUUID();
        String value1 = "Value1";
        UuidMap.put(key1, value1);

        UUID key2 = UUID.randomUUID();
        String value2 = "Value2";
        UuidMap.put(key2, value2);

        Set<Map.Entry<UUID, String>> entrySet = UuidMap.entrySet();

        assertTrue(entrySet.contains(new AbstractMap.SimpleEntry<>(key1, value1)));
        assertTrue(entrySet.contains(new AbstractMap.SimpleEntry<>(key2, value2)));
    }
}
