public void solve(int testNumber, ScanReader in, PrintWriter out) {
    n = in.scanInt();
    int m = in.scanInt();
    arr = new int[n + 1];
    mat = new boolean[n + 1][n + 1];
    for (int i = 0; i < m; i++) {
        int a = in.scanInt();
        int b = in.scanInt();
        mat[b][a] = mat[a][b] = true;
    }
    for (int i = 0; i <= 6; i++) {
        arr[1] = i;
        dfs(2);
    }
    out.println(ans);
}