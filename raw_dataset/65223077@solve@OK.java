private static void solve(FastScanner in, PrintWriter out) {
    int count = 0;
    int n = in.nextInt();
    int m = in.nextInt();
    ar = new ArrayList[n];
    vis = new boolean[n];
    for (int i = 0; i < n; i++) ar[i] = new ArrayList<Integer>();
    for (int i = 0; i < m; i++) {
        int u = in.nextInt() - 1;
        int v = in.nextInt() - 1;
        ar[u].add(v);
        ar[v].add(u);
    }
    for (int i = 0; i < n; i++) {
        if (!vis[i]) {
            if (i < mx)
                count++;
            dfs(i);
        }
    }
    out.write(count + "\n");
}