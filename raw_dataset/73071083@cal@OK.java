static void cal(int u, int p) {
    if (c[u] == 1) {
        res[u] = 1;
    } else
        res[u] = -1;
    for (int v : ad[u]) if (p != v) {
        cal(v, u);
        res[u] += Math.max(0, res[v]);
    }
}