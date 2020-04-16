private int find(int x) {
    int p;
    while (((p = rootPtr[x]) != x)) {
        rootPtr[x] = rootPtr[p];
        x = p;
    }
    return x;
}