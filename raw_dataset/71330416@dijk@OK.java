int[] dijk(int src) {
    int[] dp = new int[n];
    Arrays.fill(dp, oo);
    dp[src] = 0;
    PriorityQueue<path> q = new PriorityQueue<>();
    q.add(new path(src, 0));
    while (q.size() > 0) {
        path p = q.poll();
        if (p.d > dp[p.v])
            continue;
        for (int i : adj[p.v]) {
            if (p.d + 1 < dp[i]) {
                dp[i] = p.d + 1;
                q.add(new path(i, dp[i]));
            }
        }
    }
    return dp;
}