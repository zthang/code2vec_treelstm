public void solve() {
    int t = sc.ni();
    while (t-- > 0) {
        int n = sc.ni();
        int m = sc.ni();
        int a = sc.ni();
        int b = sc.ni();
        visit = new int[n];
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList();
        for (int i = 0; i < m; i++) {
            int x = sc.ni() - 1;
            int y = sc.ni() - 1;
            adj[x].add(y);
            adj[y].add(x);
        }
        long x = 0, y = 0;
        dfs(a - 1, b - 1);
        for (int i = 0; i < n; i++) {
            if (visit[i] == 0)
                x++;
        }
        Arrays.fill(visit, 0);
        dfs(b - 1, a - 1);
        for (int i = 0; i < n; i++) if (visit[i] == 0)
            y++;
        x--;
        y--;
        pw.println(x * y);
    }
}