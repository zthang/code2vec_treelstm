public Deque<Triangle> putIfNotExist(LongObjectHashMap<Deque<Triangle>> map, long key) {
    Deque<Triangle> list = map.get(key);
    if (list == null) {
        list = new LinkedList<>();
        map.put(key, list);
    }
    return list;
}