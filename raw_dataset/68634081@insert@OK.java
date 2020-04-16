void insert(int v) {
    sz++;
    mp.put(v, mp.getOrDefault(v, 0) + 1);
}