static void solve() throws IOException {
    scan = new FastReader();
    pw = new PrintWriter(System.out, true);
    StringBuilder sb = new StringBuilder();
    n = ni();
    a = ni();
    adj = new ArrayList[2][];
    adj[0] = new ArrayList[a + 1];
    for (int i = 1; i <= a; ++i) {
        adj[0][i] = new ArrayList<>();
    }
    for (int i = 1; i < a; ++i) {
        int x = ni();
        adj[0][x].add((i + 1));
    }
    arr = new int[2][n + 1];
    for (int i = 1; i <= n; ++i) {
        arr[0][i] = ni();
    }
    b = ni();
    adj[1] = new ArrayList[b + 1];
    for (int i = 1; i <= b; ++i) {
        adj[1][i] = new ArrayList<>();
    }
    for (int i = 1; i < b; ++i) {
        int x = ni();
        adj[1][x].add((i + 1));
    }
    for (int i = 1; i <= n; ++i) {
        arr[1][i] = ni();
    }
    path = new ArrayList[2][];
    path[0] = new ArrayList[a + 1];
    path[1] = new ArrayList[b + 1];
    path_set = new boolean[2][][];
    path_set[0] = new boolean[a + 1][a + 1];
    path_set[1] = new boolean[b + 1][b + 1];
    level = new int[2][];
    level[0] = new int[a + 1];
    level[1] = new int[b + 1];
    curr = 0;
    dfs(1, new Stack<>());
    curr = 1;
    dfs(1, new Stack<>());
    // for(int i=1;i<=a;++i) {
    // pa("Path of "+i, path[0][i]);
    // }
    // pl();
    // pl();
    // for(int i=1;i<=b;++i) {
    // pa("Path of "+i, path[1][i]);
    // }
    lca = new int[2][][];
    lca[0] = new int[a + 1][a + 1];
    lca[1] = new int[b + 1][b + 1];
    pre_calc_lcas();
    // pa("lca1", lca[0]);
    // pa("lca2", lca[1]);
    dp = new int[n + 1][3][n + 1];
    for (int i = 0; i <= n; ++i) {
        for (int j = 0; j < 3; ++j) {
            Arrays.fill(dp[i][j], -1);
        }
    }
    // for(int i=1;i<=n;++i) {
    // p(level[0][arr[0][i]]);
    // }
    // pl();
    // for(int i=1;i<=n;++i) {
    // p(level[1][arr[1][i]]);
    // }
    // pl();
    int ans = (a + b - 2) - f(1, 0, 0);
    pl(ans);
    pw.flush();
    pw.close();
}