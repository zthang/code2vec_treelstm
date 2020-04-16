static void dfs1(int x) {
    if (children.get(x).size() == 0) {
        dp[x] = ((a[x] == 1) ? 1 : -1);
        return;
    }
    int tmp = ((a[x] == 1) ? 1 : -1);
    for (Integer i : children.get(x)) {
        dfs1(i);
        tmp += Math.max(dp[i], 0);
    }
    dp[x] = tmp;
}