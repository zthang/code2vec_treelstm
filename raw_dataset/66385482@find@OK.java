static int find(int x) {
    while (x != dsu[x]) {
        dsu[x] = dsu[dsu[x]];
        x = dsu[x];
    }
    return x;
}