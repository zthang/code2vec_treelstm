private static void postorderDfs(List<Integer>[] adj, int index, int parent) {
    int max = val[index];
    for (int next : adj[index]) {
        if (next == parent) {
            continue;
        }
        postorderDfs(adj, next, index);
        max = Math.max(max, max + Math.max(dp[next], 0));
    }
    dp[index] = max;
}