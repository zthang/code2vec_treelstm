int dfs(int root, ArrayList<Integer>[] g, boolean[] visited, int end) {
    // out.println(root);
    if (root == end)
        return 0;
    if (dp[root] != 10000000)
        return dp[root];
    visited[root] = true;
    for (int i : g[root]) {
        if (!visited[i]) {
            dp[root] = Math.min(dp[root], 1 + dfs(i, g, visited, end));
        }
    }
    visited[root] = false;
    return dp[root];
}