void add(int u, int v) {
    adj[u].add(v);
    adj[v].add(u);
}