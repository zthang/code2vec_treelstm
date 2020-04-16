void solve() throws IOException {
    n = ni();
    int m = ni();
    A = new ArrayList[n + 1];
    for (int x = 1; x <= n; x++) A[x] = new ArrayList();
    for (int x = 0; x < m; x++) {
        int u = ni(), v = ni();
        A[u].add(v);
        A[v].add(u);
    }
    S = new int[n + 1];
    E = new int[n + 1];
    B = new int[n + 1][2];
    sc = 0;
    for (int x = 1; x <= n; x++) {
        if (E[x] == 0) {
            sc++;
            B[sc][0] = Integer.MAX_VALUE;
            // B[sc][2]=sc;
            dfs(x, 0);
        }
    }
    Arrays.sort(B, (a, b) -> Integer.compare(a[0], b[0]));
    int ans = 0;
    int cmax = 0;
    for (int x = 0; x <= n; x++) {
        if (B[x][0] == 0)
            continue;
        if (B[x][0] > cmax) {
            cmax = B[x][1];
            continue;
        }
        ans++;
        cmax = Math.max(cmax, B[x][1]);
    }
    System.out.println(ans);
}