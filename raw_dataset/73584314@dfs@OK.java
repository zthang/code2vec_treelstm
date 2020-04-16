private int dfs(int node, int parent) {
    int ans = color[node];
    for (int next : tree.get(node)) if (next != parent) {
        int score = dfs(next, node);
        if (score > 0) {
            ans += score;
        }
    }
    return dp[node] = ans;
}