void union(int p, int q) {
    int r1 = find(p), r2 = find(q);
    if (r1 == r2)
        return;
    sz[r2] += sz[r1];
    id[r1] = r2;
}