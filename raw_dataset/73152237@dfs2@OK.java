public static void dfs2(int u, int p, int[] dp, int val, ArrayList<ArrayList<Integer>> graph) {
    dp[u] += Math.max(val, 0);
    for (int v : graph.get(u)) {
        if (v == p) {
            continue;
        }
        dfs2(v, u, dp, dp[u] - Math.max(dp[v], 0), graph);
    // if dp[v] is less than 0 then it wont be included in dp[u] thats why taken max
    }
}