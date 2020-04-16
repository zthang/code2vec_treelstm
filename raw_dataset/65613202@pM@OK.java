public static void pM(long[][] dp2, int n, int m) throws IOException {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            log.write(dp2[i][j] + " ");
        }
        log.write("\n");
    }
}