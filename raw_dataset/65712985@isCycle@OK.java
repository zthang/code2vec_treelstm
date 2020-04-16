void isCycle(int u) {
    color[u] = 1;
    for (pair p : adj[u]) {
        if (color[p.v] == 0) {
            isCycle(p.v);
            res[p.i] = 1;
        } else if (color[p.v] == 2) {
            res[p.i] = 1;
        } else {
            cyc = true;
            res[p.i] = 2;
        }
    }
    color[u] = 2;
}