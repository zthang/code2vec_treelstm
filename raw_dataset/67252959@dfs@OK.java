static void dfs(int i) {
    v[i] = true;
    for (int j : adj[i]) {
        if (!v[j])
            dfs(j);
    }
}