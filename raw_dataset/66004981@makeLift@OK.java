void makeLift(int node) {
    dep[node] = 1 + dep[p[node]];
    lift[node][0] = p[node];
    int curNode = lift[node][0];
    for (int i = 1; i < log; i++) {
        curNode = lift[curNode][i - 1];
        lift[node][i] = curNode;
    }
    for (int ii : adj[node]) makeLift(ii);
}