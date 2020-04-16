int root(int node) {
    return root[node] = (root[node] == node ? node : root(root[node]));
}