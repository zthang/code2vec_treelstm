public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    cost = new long[n + 1][3];
    color = new int[n + 1];
    for (int j = 0; j < 3; ++j) for (int i = 1; i <= n; ++i) cost[i][j] = in.nextInt();
    edges = new List[n + 1];
    for (int i = 1; i <= n; ++i) edges[i] = new ArrayList<>();
    int[] deg = new int[n + 1];
    for (int i = 0; i < n - 1; ++i) {
        int u = in.nextInt();
        int v = in.nextInt();
        edges[u].add(v);
        edges[v].add(u);
        deg[u]++;
        deg[v]++;
        if (deg[u] == 3 || deg[v] == 3) {
            out.println(-1);
            return;
        }
    }
    int u = 0, v = 0;
    for (int i = 1; i <= n; ++i) if (deg[i] == 1) {
        u = i;
        v = edges[u].get(0);
        break;
    }
    long ans = Long.MAX_VALUE;
    int[] ansColor = new int[n + 1];
    for (int cu = 0; cu < 3; ++cu) for (int cv = 0; cv < 3; ++cv) if (cu != cv) {
        Arrays.fill(color, -1);
        color[u] = cu;
        long total = cost[u][cu] + dfs(v, u, cv, cu);
        if (ans > total) {
            ans = total;
            ansColor = Arrays.copyOf(color, n + 1);
        }
    }
    out.println(ans);
    for (int i = 1; i <= n; ++i) out.print((ansColor[i] + 1) + " ");
    System.out.println();
}