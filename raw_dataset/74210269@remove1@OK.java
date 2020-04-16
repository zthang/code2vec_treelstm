static void remove1(TreeMap<Long, Integer> map, long key) {
    map.replace(key, map.get(key) - 1);
    if (map.get(key) == 0)
        map.remove(key);
}