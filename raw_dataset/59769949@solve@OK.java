void solve() {
    int n = ni(), K = ni();
    int[] P = na(n);
    int[] Q = na(n);
    int[] from = new int[2 * (n - 1)];
    int[] to = new int[2 * (n - 1)];
    int p = 0;
    for (int i = 0; i < n - 1; i++) {
        from[p] = P[i] - 1;
        to[p] = P[i + 1] - 1;
        p++;
        from[p] = Q[i] - 1;
        to[p] = Q[i + 1] - 1;
        p++;
    }
    int[][] g = packD(n, from, to);
    int[] clus = decomposeToSCCNoRec(g);
    int max = 0;
    for (int c : clus) {
        max = Math.max(max, c);
    }
    if (max + 1 >= K) {
        out.println("YES");
        for (int i = 0; i < n; i++) {
            out.print((char) ('a' + Math.min(max - clus[i], 25)));
        }
        out.println();
    } else {
        out.println("NO");
    }
}