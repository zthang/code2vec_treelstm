void add(int x, int lb) {
    if (tin.contains(x))
        return;
    set[end++] = x;
    tin.add(x);
}