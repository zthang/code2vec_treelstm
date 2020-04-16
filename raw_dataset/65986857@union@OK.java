public static void union(int a, int b) {
    int roota = root(a);
    int rootb = root(b);
    if (roota == rootb)
        return;
    if (size[roota] > size[rootb]) {
        par[rootb] = roota;
        size[roota] += size[rootb];
        size[rootb] = 0;
    } else {
        par[roota] = rootb;
        size[rootb] += size[roota];
        size[roota] = 0;
    }
}