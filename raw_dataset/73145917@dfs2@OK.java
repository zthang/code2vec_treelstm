static void dfs2(int x) {
    int tmp = ((x != 0) ? dp[parent[x]] : 0);
    dp[x] = Math.max(tmp - Math.max(dp[x], 0), 0) + ((a[x] == 1) ? 1 : -1);
    for (Integer i : children.get(x)) {
        dp[x] += Math.max(dp[i], 0);
    }
    for (Integer i : children.get(x)) {
        dfs2(i);
    }
}