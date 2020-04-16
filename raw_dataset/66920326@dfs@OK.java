static void dfs(int v, int par) {
    subtree_size[v]++;
    for (Pair e : adj[v]) {
        if (e.x != par) {
            dfs(e.x, v);
            subtree_size[v] += subtree_size[e.x];
            if (subtree_size[e.x] % 2 == 1) {
                min += e.y;
            }
            max += 1L * e.y * min(subtree_size[e.x], n - subtree_size[e.x]);
        }
    }
}