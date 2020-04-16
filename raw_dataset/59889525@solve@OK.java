void solve() {
    int n = ni(), K = ni();
    int[] p = na(n);
    int[] q = na(n);
    int[] from = new int[2 * (n - 1)];
    int[] to = new int[2 * (n - 1)];
    int ptr = 0;
    for (int i = 0; i < n - 1; i++) {
        from[ptr] = p[i] - 1;
        to[ptr++] = p[i + 1] - 1;
        from[ptr] = q[i] - 1;
        to[ptr++] = q[i + 1] - 1;
    }
    int[][] g = packD(n, from, to);
    int[] clus = decomposeToSCCNoRec(g);
    int max = 0;
    for (int c : clus) max = Math.max(c, max);
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