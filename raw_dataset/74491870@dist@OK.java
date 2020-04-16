public int dist(int u, int v) {
    return lvl[u] + lvl[v] - (lvl[query(u, v)] << 1);
}