void uniteSets(int v, int u) {
    v = findSet(v);
    u = findSet(u);
    if (v != u) {
        if (rand.nextInt() % 2 == 1) {
            v ^= u;
            u ^= v;
            v ^= u;
        }
        par[u] = v;
        size[v] += size[u];
    }
}