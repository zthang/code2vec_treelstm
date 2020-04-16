public static void dfs1(int current, int par) {
    int parent = Integer.MIN_VALUE;
    if (dp[current] > 0) {
        parent = Integer.max(dp2[par], parent);
    } else {
        parent = Integer.max(parent, dp2[par] + dp[current]);
    }
    dp2[current] = Integer.max(dp[current], Integer.max(parent, color[current] == 1 ? 1 : -1));
    for (Integer x : adj[current]) {
        if (x != par) {
            dfs1(x, current);
        }
    }
}