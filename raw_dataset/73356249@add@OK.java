public void add(int x) {
    ensureSpace(size + 1);
    data[size++] = x;
}