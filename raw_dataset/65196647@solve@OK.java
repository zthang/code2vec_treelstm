public static void solve() {
    int n = s.nextInt();
    int m = s.nextInt();
    adj = new LinkedList[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new LinkedList<Integer>();
    }
    for (int i = 0; i < m; i++) {
        int u = s.nextInt() - 1;
        int v = s.nextInt() - 1;
        adj[u].add(v);
        adj[v].add(u);
    }
    out.println(dfs_Util());
}