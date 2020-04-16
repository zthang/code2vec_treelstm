static int dfs(int i, int p) {
    int di = -1;
    if (c[i] == 1)
        di = 1;
    for (int j : arr[i]) {
        if (j != p) {
            di += (Math.max(0, dfs(j, i)));
        }
    }
    return dp[i] = di;
}