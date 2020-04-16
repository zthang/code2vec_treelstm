static void dfs1(int i, int par) {
    for (int node : adj[i]) {
        if (node != par) {
            dfs1(node, i);
            count[i] += Math.max(count[node], 0);
        }
    }
    count[i] += a[i];
}