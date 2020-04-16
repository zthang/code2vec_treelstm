public void solve(int testNumber, ScanReader in, PrintWriter out) {
    n = in.scanInt() * 2;
    int[] from = new int[n - 1];
    int[] to = new int[n - 1];
    int[] weight = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
        from[i] = in.scanInt();
        to[i] = in.scanInt();
        weight[i] = in.scanInt();
    }
    max = min = 0;
    G = CodeHash.packGraphW(from, to, weight, n);
    dfs(1, -1);
    out.println(min + " " + max);
}