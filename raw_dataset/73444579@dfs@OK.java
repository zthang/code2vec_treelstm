static int dfs(ArrayList<Integer>[] gr, int p, int pa) {
    dp[p] = a[p];
    for (Integer ch : gr[p]) {
        if (ch != pa)
            dp[p] += Math.max(0, dfs(gr, ch, p));
    }
    return dp[p];
}