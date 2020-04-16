public void solve() {
    int n = sc.ni();
    brr = new int[n];
    wrr = new int[n];
    visit = new int[n];
    col = new int[n];
    adj = new ArrayList[n];
    for (int i = 0; i < n; i++) adj[i] = new ArrayList();
    for (int i = 0; i < n; i++) col[i] = sc.ni();
    for (int i = 0; i < n - 1; i++) {
        int x = sc.ni() - 1;
        int y = sc.ni() - 1;
        adj[x].add(y);
        adj[y].add(x);
    }
    dfs(0);
    Arrays.fill(visit, 0);
    dfs1(0, 0, 0);
    for (int i = 0; i < n; i++) pw.print(Math.max(brr[i], -1) + " ");
}