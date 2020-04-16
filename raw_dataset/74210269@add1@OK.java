static void add1(TreeMap<Long, Integer> map, long key) {
    map.putIfAbsent(key, 0);
    map.replace(key, map.get(key) + 1);
}