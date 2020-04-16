public static void reroot(int curr, boolean[] seen, LinkedList<Integer>[] edges, int[] dp, int[] arr) {
    seen[curr] = true;
    res[curr] = dp[curr];
    for (int next : edges[curr]) if (!seen[next]) {
        int val = dp[next];
        int val2 = dp[curr];
        // set down
        if (val >= 0)
            dp[curr] -= val;
        dp[next] += Math.max(0, dp[curr]);
        reroot(next, seen, edges, dp, arr);
        dp[curr] = val2;
        dp[next] = val;
    }
}