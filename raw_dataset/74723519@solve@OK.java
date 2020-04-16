private static void solve(MyScanner sc, PrintWriter out) {
    int n = sc.nextInt();
    int m = sc.nextInt();
    graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) graph[i] = new ArrayList<Integer>();
    for (int i = 0; i < n - 1; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        graph[u].add(v);
        graph[v].add(u);
    }
    dep = new int[n + 1];
    par = new int[n + 1];
    tin = new int[n + 1];
    tout = new int[n + 1];
    dfs(1, -1, 0);
    int k;
    for (int i = 0; i < m; i++) {
        k = sc.nextInt();
        int[] nodes = new int[k];
        for (int j = 0; j < k; j++) nodes[j] = sc.nextInt();
        int deepestNode = nodes[0];
        for (int j = 1; j < k; j++) {
            if (dep[deepestNode] < dep[nodes[j]]) {
                deepestNode = nodes[j];
            }
        }
        for (int j = 0; j < k; j++) {
            if (par[nodes[j]] == -1 || nodes[j] == deepestNode)
                continue;
            nodes[j] = par[nodes[j]];
        }
        boolean ok = true;
        for (int j = 0; j < k; j++) {
            ok &= isAnc(nodes[j], deepestNode);
        }
        if (ok) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    }
    return;
}