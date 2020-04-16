public static void dfs1(int index, int par) {
    vis[index] = true;
    dp[index] = diff[index];
    if (par != -1)
        dp[index] += Math.max(0, dp[par] - Math.max(0, diff[index]));
    for (int i = 0; i < graph[index].size(); i++) {
        int v = graph[index].get(i);
        if (!vis[v]) {
            dfs1(v, index);
        }
    }
}