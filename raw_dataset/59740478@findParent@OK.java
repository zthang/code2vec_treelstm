int findParent(int node) {
    int par = node;
    while (parent[par] >= 0) par = parent[par];
    while (parent[node] >= 0) {
        int temp = parent[node];
        parent[node] = par;
        node = temp;
    }
    return par;
}