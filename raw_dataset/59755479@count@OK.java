public long count() {
    long cnt = 0;
    for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
        long key = pair.getKey(), value = pair.getValue();
        cnt += (key * (key - 1)) / 2L * value;
    }
    return cnt;
}