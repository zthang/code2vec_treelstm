public void run() {
    c = new InputReader(System.in);
    w = new PrintWriter(System.out);
    int n = c.nextInt(), k = c.nextInt();
    ArrayList<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
    for (int i = 0; i < k; i++) {
        int u = c.nextInt() - 1, v = c.nextInt() - 1;
        adj[u].add(v);
        adj[v].add(u);
    }
    res = k;
    vis = new boolean[n];
    for (int i = 0; i < n; i++) if (!vis[i])
        dfs(i, adj, -1);
    w.println(res);
    w.close();
}