public void addEdge(int x, int y) {
    adj[x].add(y);
    adj[y].add(x);
}