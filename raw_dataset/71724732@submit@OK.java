void submit() {
    int n = nextInt();
    int k = nextInt();
    int[][] a = new int[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            a[i][j] = nextInt();
        }
    }
    long start = System.currentTimeMillis();
    int[] evenBuf = new int[n];
    int[] oddBuf = new int[n];
    int ans = Integer.MAX_VALUE;
    while (System.currentTimeMillis() - start < 2500) {
        int s0 = 0;
        int s1 = 0;
        evenBuf[s0++] = 0;
        for (int i = 1; i < n; i++) {
            if (rng.nextBoolean()) {
                evenBuf[s0++] = i;
            } else {
                oddBuf[s1++] = i;
            }
        }
        if (s0 == 0 || s1 == 0) {
            continue;
        }
        int[] even = Arrays.copyOf(evenBuf, s0);
        int[] odd = Arrays.copyOf(oddBuf, s1);
        int[] dp = new int[n];
        for (int v : oddBuf) {
            dp[v] = a[0][v];
        }
        for (int i = 1; i < k; i++) {
            int[] from = i % 2 == 1 ? odd : even;
            int[] to = i % 2 == 0 ? odd : even;
            for (int v : to) {
                dp[v] = Integer.MAX_VALUE;
                for (int u : from) {
                    dp[v] = Math.min(dp[v], dp[u] + a[u][v]);
                }
            }
        }
        ans = Math.min(ans, dp[0]);
    }
    out.println(ans);
}