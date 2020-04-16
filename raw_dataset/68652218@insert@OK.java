void insert(int v) {
    sz1++;
    mp.put(v, mp.getOrDefault(v, 0) + 1);
}