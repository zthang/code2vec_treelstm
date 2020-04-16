private static void finish(int i) {
    fin[i] = dp[i];
    visited[i] = true;
    // rotate tree along ea. edge from i to a child
    // this way we won't have to reprocess the entire tree
    int pd = dp[i];
    for (int n : neighbors.get(i)) if (!visited[n]) {
        int pdc = dp[n];
        dp[i] -= Math.max(0, dp[n]);
        dp[n] += Math.max(0, dp[i]);
        finish(n);
        dp[i] = pd;
        dp[n] = pdc;
    }
}