public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int n = in.scanInt();
    c = new long[4][n + 1];
    col = new int[n + 1];
    Arrays.fill(col, -1);
    chain = new int[n];
    for (int i = 1; i <= n; i++) c[1][i] = in.scanLong();
    for (int i = 1; i <= n; i++) c[2][i] = in.scanLong();
    for (int i = 1; i <= n; i++) c[3][i] = in.scanLong();
    int[] from = new int[n - 1];
    int[] to = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
        from[i] = in.scanInt();
        to[i] = in.scanInt();
    }
    g = CodeX.packGraph(from, to, n);
    int start = -1;
    for (int i = 1; i <= n; i++) {
        if (g[i].length > 2) {
            out.println(-1);
            return;
        }
        if (g[i].length == 1)
            start = i;
    }
    if (start == -1)
        start = 1;
    makechain(start, -1);
    {
        int[][] parmutations = new int[6][];
        parmutations[0] = new int[] { 1, 2, 3 };
        parmutations[1] = new int[] { 1, 3, 2 };
        parmutations[2] = new int[] { 2, 1, 3 };
        parmutations[3] = new int[] { 2, 3, 1 };
        parmutations[4] = new int[] { 3, 2, 1 };
        parmutations[5] = new int[] { 3, 1, 2 };
        long aa = Long.MAX_VALUE;
        for (int j = 0; j < 6; j++) {
            long sum = 0;
            for (int i = 0; i < n; i++) sum += c[parmutations[j][i % 3]][chain[i]];
            aa = Math.min(sum, aa);
        }
        for (int j = 0; j < 6; j++) {
            long sum = 0;
            for (int i = 0; i < n; i++) sum += c[parmutations[j][i % 3]][chain[i]];
            for (int i = 0; i < n; i++) col[chain[i]] = parmutations[j][i % 3];
            if (sum == aa) {
                out.println(aa);
                for (int i = 1; i <= n; i++) out.print(col[i] + " ");
                return;
            }
        }
    }
}