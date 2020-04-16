static void dfs(boolean[] vis, List<Integer>[] adj, List<Integer> v, int node) {
    for (int i : adj[node]) {
        if (!vis[i]) {
            vis[i] = true;
            v.add(i);
            dfs(vis, adj, v, i);
        }
    }
}