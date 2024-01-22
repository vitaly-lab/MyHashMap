package com.example;

import util.UuidMap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class App {
    public static void main(String[] args) {

        Map<UUID, String> stringHashMapMy = new UuidMap();
        Map<UUID, String> stringHashMapMy2 = new UuidMap();

        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();
        UUID uuid3 = UUID.randomUUID();
        UUID uuid4 = UUID.randomUUID();
        UUID uuid5 = UUID.randomUUID();
        UUID uuid6 = UUID.randomUUID();
        UUID uuid7 = UUID.randomUUID();
        UUID uuid8 = UUID.randomUUID();
        UUID uuid9 = UUID.randomUUID();
        UUID uuid10 = UUID.randomUUID();
        UUID uuid11 = UUID.randomUUID();
        UUID uuid12 = UUID.randomUUID();
        UUID uuid13 = UUID.randomUUID();
        UUID uuid14 = UUID.randomUUID();
        UUID uuid15 = UUID.randomUUID();
        UUID uuid16 = UUID.randomUUID();
        UUID uuid17 = UUID.randomUUID();


        stringHashMapMy.put(uuid1, "aaa");
        stringHashMapMy.put(uuid2, "bbb");
        stringHashMapMy.put(uuid3, "ccc");
        stringHashMapMy.put(uuid4, "ddd");
        stringHashMapMy.put(uuid5, "fff");
        stringHashMapMy.put(uuid6, "ggg");
        stringHashMapMy.put(uuid7, "hhh");
        stringHashMapMy.put(uuid8, "jjj");
        stringHashMapMy.put(uuid9, "kkk");
        stringHashMapMy.put(uuid10, "lll");
        stringHashMapMy.put(uuid11, "zzz");
        stringHashMapMy.put(uuid12, "vvv");
        stringHashMapMy.put(uuid13, "qqq");
        stringHashMapMy.put(uuid14, "rrr");
        stringHashMapMy2.put(uuid15, "uuu");
        stringHashMapMy2.put(uuid16, "ppp");
        stringHashMapMy2.put(uuid17, "mmm");

        // 2. get();
        System.out.println("get(); " + stringHashMapMy.get(uuid12));

        // 3. size();
        System.out.println("size(); " + stringHashMapMy.size());

        // 4. isEmpty();
        System.out.println("Is the map empty? " + stringHashMapMy.isEmpty());

        // 5. containsKey();
        System.out.println("containsKey(); " + stringHashMapMy.containsKey(uuid12));
        System.out.println("containsKey(); " + stringHashMapMy.containsKey(UUID.randomUUID()));

// 6. containsValue();
        System.out.println("containsValue(); " + stringHashMapMy.containsValue("ppp"));
        System.out.println("containsValue(); " + stringHashMapMy.containsValue("12345"));

// 7.  remove();
        stringHashMapMy.remove(uuid12);
        System.out.println("remove(uuid12); " + stringHashMapMy.get(uuid12));

// 8. putAll();
        stringHashMapMy.putAll(stringHashMapMy2);
        System.out.println("putAll(); " + stringHashMapMy.get(uuid17));

// 10. keySet();
        Set<UUID> keySet = stringHashMapMy.keySet();
        System.out.println("Key Set: " + keySet);

// 11. values();
        Collection<String> values = stringHashMapMy.values();
        System.out.println("Values in the map: " + values);

// 12.
        Set<Map.Entry<UUID, String>> entrySet = stringHashMapMy.entrySet();

        for (Map.Entry<UUID, String> entry : entrySet) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

// 9. clear();
        stringHashMapMy.clear();
        System.out.println("clear(); " + stringHashMapMy.get(uuid1));

    }
}
