public int getParent(int u, int dist) {
    int lg = log;
    for (int i = lg - 1; i >= 0; i--) {
        if ((1 << i) <= dist) {
            u = lca[u][i];
            dist -= (1 << i);
        }
    }
    return u;
}