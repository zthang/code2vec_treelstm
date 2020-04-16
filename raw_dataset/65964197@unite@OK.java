void unite(int x, int y) {
    int x_root = find(x);
    int y_root = find(y);
    if (x_root == y_root)
        return;
    if (sz[x_root] <= sz[y_root]) {
        par[x_root] = y_root;
        sz[y_root] += sz[x_root];
    } else {
        par[y_root] = x_root;
        sz[x_root] += sz[y_root];
    }
}