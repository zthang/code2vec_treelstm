int union(int u, int v) {
    int root_u = find(u);
    int root_v = find(v);
    if (root_u == root_v) {
        return size[root_u];
    }
    int size_u = size[root_u];
    int size_v = size[root_v];
    if (size_u > size_v) {
        parent[root_v] = root_u;
        size[root_u] += size_v;
        return size[root_u];
    } else {
        parent[root_u] = root_v;
        size[root_v] += size_u;
        return size[root_v];
    }
}