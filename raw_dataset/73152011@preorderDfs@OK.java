private static void preorderDfs(List<Integer>[] adj, int index, int parent) {
    for (int next : adj[index]) {
        if (next == parent) {
            continue;
        }
        dp[next] += Math.max(dp[index] - Math.max(dp[next], 0), 0);
        preorderDfs(adj, next, index);
    }
}