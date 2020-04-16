void getsums(int node) {
    cumsum[node] = new int[adj[node].size()];
    for (int i = 0; i < adj[node].size(); i++) {
        int a = adj[node].get(i);
        cumsum[node][i] += 1 + numEdges[a];
        if (i > 0)
            cumsum[node][i] += cumsum[node][i - 1];
    }
    for (int ii : adj[node]) getsums(ii);
}