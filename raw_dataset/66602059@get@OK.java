int get(long val) {
    if (val > Integer.MAX_VALUE || val < Integer.MIN_VALUE)
        return -1;
    int key = (int) val;
    if (map.containsKey(key) == false)
        return -1;
    return map.get(key);
}