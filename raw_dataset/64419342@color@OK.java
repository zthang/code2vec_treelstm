int color(int[][] diff, int N) {
    int[] val = new int[1 << N];
    val[0] = 1;
    for (int i = 0; i < (1 << N); i++) {
        for (int j = 0; j < N; j++) {
            if (contains(i, j)) {
                if (val[bitremove(i, j)] == 1) {
                    boolean b = true;
                    for (int k = 0; k < N; k++) {
                        if (contains(i, k) && diff[j][k] == 1) {
                            b = false;
                        }
                    }
                    if (b)
                        val[i] = 1;
                }
                break;
            }
        }
    }
    int[] dp = new int[1 << N];
    Arrays.fill(dp, mod);
    ;
    dp[0] = 0;
    for (int i = 0; i < (1 << N); i++) {
        for (int j = i; j > 0; j = (j - 1) & i) {
            if (val[j] == 1)
                dp[i] = Math.min(dp[i], dp[i ^ j] + 1);
        }
    }
    return dp[(1 << N) - 1];
}