public int par(int node) {
    if (parent[node] == node) {
        return node;
    }
    parent[node] = par(parent[node]);
    return parent[node];
}