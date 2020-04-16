private void dfs2(int node, int parent) {
    ans[node] = dp[node];
    for (int next : tree.get(node)) {
        if (next != parent) {
            dp[node] -= max(0, dp[next]);
            dp[next] += max(0, dp[node]);
            dfs2(next, node);
            dp[next] -= max(0, dp[node]);
            dp[node] += max(0, dp[next]);
        }
    }
}