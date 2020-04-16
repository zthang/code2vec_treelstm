private int[] bfs(Graph g, int s) {
    int n = g.n;
    int[] q = new int[n];
    int[] d = new int[n];
    Arrays.fill(d, n);
    d[s] = 0;
    q[0] = s;
    int qt = 0;
    int qh = 1;
    while (qt < qh) {
        int v = q[qt++];
        for (int e = g.firstEdge[v]; e >= 0; e = g.edgeNxt[e]) {
            int u = g.edgeDst[e];
            if (d[u] > 1 + d[v]) {
                d[u] = 1 + d[v];
                q[qh++] = u;
            }
        }
    }
    return d;
}