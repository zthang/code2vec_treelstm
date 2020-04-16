void dfs(int u, int p) {
    onCycle[u] = 1;
    for (int ii = 0; ii < adj[u].length; ii++) {
        int v = adj[u][ii];
        int we = adjW[u][ii];
        if (v == p)
            continue;
        if (onCycle[v] == 1) {
            IntList addCycle = new IntList();
            int cur = u;
            while (cur != v) {
                addCycle.add(weights[cur]);
                cur = par[cur];
            }
            addCycle.add(we);
            cycles.add(addCycle);
        } else if (onCycle[v] == 0) {
            weights[v] = we;
            par[v] = u;
            dfs(v, u);
        }
    }
    onCycle[u] = 2;
}