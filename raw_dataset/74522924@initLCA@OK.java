public static void initLCA() {
    for (int d = 1; d < MAXD; d++) {
        for (int i = 0; i < n + 1; i++) {
            lca[i][d] = lca[lca[i][d - 1]][d - 1];
        }
    }
}