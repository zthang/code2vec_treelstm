public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int n = in.scanInt();
    int m = in.scanInt();
    int[] from = new int[m];
    int[] to = new int[m];
    int[] weight = new int[m];
    for (int i = 0; i < m; i++) {
        from[i] = in.scanInt();
        to[i] = in.scanInt();
        weight[i] = i;
    }
    G = CodeHash.packGraphWDirected(from, to, weight, n, m);
    int[] order = sortTopologically(G);
    if (order != null) {
        out.println(1);
        for (int i = 1; i <= m; i++) out.print(1 + " ");
        return;
    }
    out.println(2);
    for (int i = 0; i < m; i++) {
        if (from[i] < to[i]) {
            out.print(1 + " ");
        } else {
            out.print(2 + " ");
        }
    }
}