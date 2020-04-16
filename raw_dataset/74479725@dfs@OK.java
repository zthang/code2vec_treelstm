private static void dfs(int i) {
    visited[i] = true;
    for (int n : neighbors.get(i)) {
        if (!visited[n]) {
            depth[n] = depth[i] + 1;
            par[n] = i;
            dfs(n);
        }
    }
}