int lca(int a, int b) {
    // Make a the lower node
    if (dep[b] > dep[a]) {
        int tmp = a;
        a = b;
        b = tmp;
    }
    // Lift a to node b
    for (int i = log - 1; i >= 0; i--) {
        if (dep[lift[a][i]] >= dep[b])
            a = lift[a][i];
    }
    if (a == b)
        return a;
    // lift both at same time until under lca
    for (int i = log - 1; i >= 0; i--) {
        if (lift[a][i] != lift[b][i]) {
            a = lift[a][i];
            b = lift[b][i];
        }
    }
    return lift[a][0];
}