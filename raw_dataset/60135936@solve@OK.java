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
    loop = false;
    visited = new boolean[n + 1];
    LOL = new boolean[n + 1];
    for (int i = 1; i <= n; i++) dfs(i, -1);
    if (!loop) {
        out.println(1);
        for (int i = 1; i <= m; i++) out.print(1 + " ");
        return;
    }
    ans = new int[m];
    visited = new boolean[n + 1];
    LOL = new boolean[n + 1];
    for (int i = 1; i <= n; i++) dfs1(i);
    out.println(2);
    for (int i = 0; i < m; i++) out.print((ans[i]) + " ");
}