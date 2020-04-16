public static void merge(int u, int v) {
    int p1 = find(u), p2 = find(v);
    if (p1 == p2)
        return;
    connected--;
    if (size[p1] > size[p2]) {
        size[p1] += size[p2];
        par[p2] = p1;
    } else {
        size[p2] += size[p1];
        par[p1] = p2;
    }
}