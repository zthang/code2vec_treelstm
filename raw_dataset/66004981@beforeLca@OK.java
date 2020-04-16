int beforeLca(int node, int lca) {
    for (int i = log - 1; i >= 0; i--) {
        if (dep[lift[node][i]] > dep[lca])
            node = lift[node][i];
    }
    return node;
}