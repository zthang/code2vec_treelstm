void sort(int node) {
    Collections.sort(adj[node], (a, b) -> minCon[a] - minCon[b]);
    for (int i = 0; i < adj[node].size(); i++) indexInP[adj[node].get(i)] = i;
    for (int ii : adj[node]) {
        sort(ii);
        numEdges[node] += 1 + numEdges[ii];
    }
}