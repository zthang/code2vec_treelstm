public static void union(int u, int v) {
    int root_u = find(u);
    int root_v = find(v);
    if (root_u == root_v)
        return;
    else if (size[root_u] > size[root_v]) {
        size[root_u] += size[root_v];
        arr[root_v] = root_u;
    } else {
        size[root_v] += size[root_u];
        arr[root_u] = root_v;
    }
}