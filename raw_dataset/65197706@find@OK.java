private int find(int p) {
    int root = p;
    while (par[root] != root) {
        root = par[root];
    }
    while (p != root) {
        int tmp = par[p];
        par[p] = root;
        p = tmp;
    }
    return root;
}