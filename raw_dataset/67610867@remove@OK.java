static void remove(Map<Long, Integer> map, long key) {
    Integer val = map.get(key);
    if (val == null) {
        return;
    }
    if (val == 1) {
        map.remove(key);
    }
    map.put(key, val - 1);
}