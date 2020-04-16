static void trace(int i, int p, int c1, int c2) {
    int colour = 0;
    long val = Long.MAX_VALUE;
    for (int k = 1; k <= 3; k++) {
        if (k != c1 && k != c2) {
            long v = cost[k][i];
            for (int j : gph[i]) {
                if (j != p) {
                    v += dfs(j, i, c2, k, 0);
                }
            }
            if (v < val) {
                val = v;
                colour = k;
            }
        }
    }
    anss[i] = colour;
    for (int j : gph[i]) {
        if (j != p)
            trace(j, i, c2, colour);
    }
}