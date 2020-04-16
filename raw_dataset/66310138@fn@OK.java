private static int[] fn(int r, int a, int[] osn, int[] sizeOne, int k, q x, int[] sz) {
    x.add(mas[r][k]);
    while (!x.empty()) {
        int v = x.get();
        if (v != 0) {
            sz[osn[v]]++;
            sz[a]++;
            if (sz[osn[v]] == sizeOne[osn[v]]) {
                x.add(osn[v]);
            }
        }
        x.erase();
    }
    return sz;
}