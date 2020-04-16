static void dfs(int v, int l) {
    lev[v] = l;
    for (int e : adj[v]) {
        if (lev[e] == -1) {
            par[e] = v;
            dfs(e, l + 1);
        } else if (e != par[v]) {
            if (lev[v] - lev[e] + 1 > max_cycle_len) {
                max_cycle_len = lev[v] - lev[e] + 1;
                from = v;
                to = e;
            }
        }
    }
}