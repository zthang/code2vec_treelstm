static void dfsCol(int v, int c) {
    col[v] = c;
    for (Edge edge : graph[v]) {
        int u = edge.getOther(v);
        if (col[u] != -1)
            continue;
        if (edge.isBridge)
            dfsCol(u, curCol++);
        else
            dfsCol(u, c);
    }
}