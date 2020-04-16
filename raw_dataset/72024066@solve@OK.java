void solve(int TC) {
    int n = ni(), K = ni();
    int[][] g = new int[n][n];
    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) g[i][j] = ni();
    Random r = new Random();
    long ans = IINF;
    for (int IT = 0; IT < 5000; IT++) {
        int[] col = new int[n];
        for (int i = 0; i < n; i++) col[i] = r.nextInt(2);
        long[][] D = new long[1 + K][n];
        for (int k = 0; k <= K; k++) for (int i = 0; i < n; i++) D[k][i] = IINF;
        D[0][0] = 0;
        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (col[i] == col[j])
                        continue;
                    D[k][j] = Math.min(D[k][j], D[k - 1][i] + g[i][j]);
                }
            }
        }
        ans = Math.min(ans, D[K][0]);
    }
    pn(ans);
}