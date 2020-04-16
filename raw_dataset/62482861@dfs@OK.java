public static void dfs(int curr, int prev, ArrayList<Integer>[] tree, long[][] c) {
    if (tree[curr].size() == 1 && curr != ROOT) {
        dp[FS][curr] = dp[FT][curr] = c[F][curr];
        dp[SF][curr] = dp[ST][curr] = c[S][curr];
        dp[TF][curr] = dp[TS][curr] = c[T][curr];
        return;
    }
    long[] sum = new long[6];
    for (int next : tree[curr]) {
        if (next == prev)
            continue;
        dfs(next, curr, tree, c);
        for (int j = 0; j < 6; j++) sum[j] += dp[j][next];
    }
    dp[FS][curr] = c[F][curr] + sum[ST];
    dp[FT][curr] = c[F][curr] + sum[TS];
    dp[SF][curr] = c[S][curr] + sum[FT];
    dp[ST][curr] = c[S][curr] + sum[TF];
    dp[TF][curr] = c[T][curr] + sum[FS];
    dp[TS][curr] = c[T][curr] + sum[SF];
}