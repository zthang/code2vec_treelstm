public void solve(int testNumber, FastScanner in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    boolean[] marked = new boolean[n];
    for (int i = 0; i < k; i++) {
        int x = in.nextInt() - 1;
        marked[x] = true;
    }
    Graph g = new Graph(n);
    for (int i = 0; i < m; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        g.addEdge(a, b);
        g.addEdge(b, a);
    }
    int[] da = bfs(g, 0);
    int[] db = bfs(g, n - 1);
    // min(da[x] + db[y], da[y] + db[x]) + 1
    // da[x] + db[y] < da[y] + db[x]
    // da[x] - db[x] < da[y] - db[y]
    Integer[] order = new Integer[n];
    for (int i = 0; i < n; i++) {
        order[i] = i;
    }
    Arrays.sort(order, (u, v) -> ((da[u] - db[u]) - (da[v] - db[v])));
    int ans = 0;
    int bestX = -1;
    for (int y : order) {
        if (!marked[y]) {
            continue;
        }
        if (bestX >= 0) {
            int cur = da[n - 1];
            cur = Math.min(cur, da[bestX] + db[y] + 1);
            ans = Math.max(ans, cur);
        }
        if (bestX < 0 || da[bestX] < da[y]) {
            bestX = y;
        }
    }
    out.println(ans);
}