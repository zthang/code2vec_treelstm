private int root(int s) {
    int res = s;
    while (C[res] != res) res = C[res];
    int v = s;
    while (v != res) {
        int w = v;
        v = C[v];
        C[w] = res;
    }
    return res;
}