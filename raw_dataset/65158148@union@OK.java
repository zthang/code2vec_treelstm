private int union(int[] parent, int[] sz, int ds, int i, int j) {
    int root_j = root(parent, j);
    int root_i = root(parent, i);
    if (root_j != root_i) {
        ds--;
        if (sz[root_i] >= sz[root_j]) {
            parent[root_j] = parent[root_i];
            sz[root_i] += sz[root_j];
        } else {
            parent[root_i] = parent[root_j];
            sz[root_j] += sz[root_i];
        }
    }
    return ds;
}