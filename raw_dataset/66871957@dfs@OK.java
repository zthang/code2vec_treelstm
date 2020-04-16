private void dfs(Graph g, int v, int forbidden, boolean[] was) {
    was[v] = true;
    if (v == forbidden) {
        return;
    }
    for (int e = g.firstEdge[v]; e >= 0; e = g.edgeNxt[e]) {
        int u = g.edgeDst[e];
        if (!was[u]) {
            dfs(g, u, forbidden, was);
        }
    }
}