ArrayList<Integer>[] ng(int n, int e) {
    ArrayList<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < e; i++) {
        int a = ni() - 1;
        int b = ni() - 1;
        adj[a].add(b);
        adj[b].add(a);
    }
    return adj;
}