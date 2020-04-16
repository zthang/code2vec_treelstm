private static int findparent(int[] parent, int node) {
    if (parent[node] == node)
        return node;
    parent[node] = findparent(parent, parent[node]);
    return parent[node];
}