public int parent(int x) {
    if (p[x] != x)
        p[x] = parent(p[x]);
    return p[x];
}