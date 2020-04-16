static void add(Map<Long, Integer> map, long key) {
    Integer val = map.get(key);
    if (val == null) {
        map.put(key, 1);
    } else {
        map.put(key, val + 1);
    }
}