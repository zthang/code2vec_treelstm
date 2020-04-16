public int query(int u, int v) {
    if (lvl[u] < lvl[v]) {
        int t = u;
        u = v;
        v = t;
    }
    int dis = lvl[u] - lvl[v];
    while (dis > 0) {
        int raise = log2(dis);
        u = par[u][raise];
        dis ^= 1 << raise;
    }
    if (u == v)
        return u;
    for (int i = LOG - 1; i >= 0; i--) {
        if (par[u][i] != -1 && par[u][i] != par[v][i]) {
            u = par[u][i];
            v = par[v][i];
        }
    }
    return par[u][0];
}