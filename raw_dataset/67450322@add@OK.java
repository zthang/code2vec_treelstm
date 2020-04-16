public void add(long x) {
    ensureSpace(size + 1);
    data[size++] = x;
}