public void remake() {
    adj = new Node[adjList.size()];
    for (int i = 0; i < adj.length; i++) adj[i] = adjList.get(i);
}