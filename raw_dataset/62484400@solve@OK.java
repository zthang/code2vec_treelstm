public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int n = in.scanInt();
    c = new int[n + 1][3];
    dp = new long[n + 1][6];
    for (int i = 1; i <= n; i++) c[i][0] = in.scanInt();
    for (int i = 1; i <= n; i++) c[i][1] = in.scanInt();
    for (int i = 1; i <= n; i++) c[i][2] = in.scanInt();
    int[] from = new int[n - 1];
    int[] to = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
        from[i] = in.scanInt();
        to[i] = in.scanInt();
    }
    G = CodeHash.packGraph(from, to, n);
    flag = true;
    map = new int[6];
    map[0] = 3;
    map[1] = 5;
    map[2] = 1;
    map[3] = 4;
    map[4] = 0;
    map[5] = 2;
    this.dis = -1;
    this.farthest = -1;
    dfss(1, -1, 0);
    dfs(this.farthest, -1);
    if (!flag) {
        out.println(-1);
        return;
    }
    int which = 0;
    long ans = Long.MAX_VALUE;
    answer = new int[n + 1];
    for (int i = 0; i < 6; i++) {
        if (ans > dp[this.farthest][i]) {
            ans = dp[this.farthest][i];
            which = i;
        }
    }
    dfs1(this.farthest, -1, which);
    out.println(ans);
    for (int i = 1; i <= n; i++) {
        out.print(answer[i] + " ");
    }
}