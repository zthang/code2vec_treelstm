static void dfs(int i) {
    vis[i] = true;
    mx = Math.max(mx, i);
    for (int j : edges[i]) {
        if (!vis[j]) {
            dfs(j);
        }
    }
}