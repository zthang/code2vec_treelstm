void addEdge(int a, int b) {
    adj[a].add(b);
    adj[b].add(a);
}