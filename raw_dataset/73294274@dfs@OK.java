public static int dfs(int curr, boolean[] seen, LinkedList<Integer>[] edges, int[] dp, int[] arr) {
    seen[curr] = true;
    int sum = 0;
    for (int next : edges[curr]) if (!seen[next])
        sum += Math.max(0, dfs(next, seen, edges, dp, arr));
    dp[curr] = Math.max(dp[curr], sum + arr[curr]);
    return dp[curr];
}