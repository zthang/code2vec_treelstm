public static int dfs1(int u, int p, ArrayList<ArrayList<Integer>> graph, int[] dp, int[] arr) {
    for (int v : graph.get(u)) {
        if (v == p) {
            continue;
        }
        dp[u] += Math.max(dfs1(v, u, graph, dp, arr), 0);
    }
    return dp[u] += arr[u];
}