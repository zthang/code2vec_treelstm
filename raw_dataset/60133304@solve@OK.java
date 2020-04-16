public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int n = in.scanInt();
    int m = in.scanInt();
    int k = 1;
    visited = new boolean[n + 1];
    incycle = new boolean[n + 1];
    arrayList = new ArrayList[n + 1];
    ans = new int[m];
    for (int i = 0; i <= n; i++) arrayList[i] = new ArrayList<>();
    for (int i = 0; i < m; i++) {
        int a = in.scanInt();
        int b = in.scanInt();
        arrayList[a].add(new pair(b, i));
    }
    Arrays.fill(ans, 1);
    for (int i = 1; i <= n; i++) if (!visited[i])
        dfs(i);
    for (int i = 0; i < m; i++) if (ans[i] == 2)
        k = 2;
    out.println(k);
    for (int i = 0; i < m; i++) out.print(ans[i] + " ");
}