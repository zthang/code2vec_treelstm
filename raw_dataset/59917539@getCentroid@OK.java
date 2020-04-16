static int getCentroid(int u, int p, int n) {
    for (Edge e : adjList[u]) if (e.to != p && depth[e.to] == -1 && size[e.to] * 2 > n)
        return getCentroid(e.to, u, n);
    return u;
}