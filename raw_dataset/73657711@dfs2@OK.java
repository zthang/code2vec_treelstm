static void dfs2(int i, int par, int v) {
    ans[i] = count[i] + v;
    for (int node : adj[i]) {
        if (node != par)
            dfs2(node, i, Math.max(ans[i] - Math.max(count[node], 0), 0));
    }
}