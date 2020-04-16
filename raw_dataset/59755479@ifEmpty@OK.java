public void ifEmpty(int x) {
    map.put(x, map.get(x) - 1);
    if (map.get(x) == 0)
        map.remove(x);
}