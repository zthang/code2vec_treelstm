void buildComb(int N) {
    comb = new long[N + 1][N + 1];
    comb[0][0] = 1;
    for (int i = 1; i <= N; i++) {
        comb[i][0] = 1;
        for (int j = 1; j < N; j++) {
            comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
            if (comb[i][j] > mod)
                comb[i][j] -= mod;
        }
        comb[i][i] = 1;
    }
}