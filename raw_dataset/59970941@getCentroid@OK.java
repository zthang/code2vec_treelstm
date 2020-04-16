static int getCentroid(int u, int p, int n) {
    for (int i = head[u]; i != -1; i = next[i]) {
        Edge e = to[i];
        if (e.to != p && depth[e.to] == -1 && size[e.to] * 2 > n)
            return getCentroid(e.to, u, n);
    }
    return u;
}