public static void dfs(int current, int par) {
    int ans = color[current] == 1 ? 1 : -1;
    int sum = 0;
    for (Integer x : adj[current]) {
        if (x != par) {
            dfs(x, current);
            sum += dp[x] > 0 ? dp[x] : 0;
        }
    }
    sum += ans;
    dp[current] = Integer.max(ans, sum);
}