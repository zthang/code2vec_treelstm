public static int root(int p) {
    while (id[p] != p) {
        id[p] = id[id[p]];
        p = id[p];
    }
    return p;
}