public int root(int i) {
    while (root[i] != i) {
        root[i] = root[root[i]];
        i = root[i];
    }
    return i;
}