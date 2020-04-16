public void solve(int testNumber, InputReader in, OutputWriter out) {
    this.in = in;
    this.out = out;
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        cnt = 0;
        vis = new boolean[n + 1];
        dfs(a, b);
        int x = n - cnt - 1;
        cnt = 0;
        vis = new boolean[n + 1];
        dfs(b, a);
        int y = n - cnt - 1;
        // out.println(x + " " + y);
        out.println((long) x * y);
    }
}