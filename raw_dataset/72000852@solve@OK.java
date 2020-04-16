static void solve() {
    int n = in.nextInt();
    int k = in.nextInt();
    int[][] g = new int[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            g[i][j] = in.nextInt();
        }
    }
    int ans = INF;
    int counter = 0;
    while (counter++ < (1 << (k - 1)) * 20) {
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = (rand.nextInt() % 2 == 0) ? 0 : 1;
        }
        int[][] d = new int[n][k + 1];
        for (int i = 0; i < n; i++) Arrays.fill(d[i], INF);
        d[0][0] = 0;
        for (int kk = 1; kk <= k; kk++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (color[i] != color[j] && d[i][kk - 1] != INF) {
                        d[j][kk] = Math.min(d[j][kk], d[i][kk - 1] + g[i][j]);
                    }
                }
            }
        }
        ans = Math.min(ans, d[0][k]);
    }
    out.println(ans);
}