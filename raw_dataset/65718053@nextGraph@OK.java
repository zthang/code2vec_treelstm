public ArrayList<Integer>[] nextGraph(int n, int m) {
    ArrayList<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < m; i++) {
        int u = nextInt();
        int v = nextInt();
        u--;
        v--;
        adj[u].add(v);
        adj[v].add(u);
    }
    return adj;
}