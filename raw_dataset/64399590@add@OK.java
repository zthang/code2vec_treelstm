public void add(long x) {
    ensureSpace(1);
    data[size++] = x;
}