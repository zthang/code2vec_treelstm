boolean f_union(int u, int v) {
    if (u == v)
        return false;
    if (size[u] > size[v]) {
        size[u] += size[v];
        par[v] = u;
    } else {
        size[v] += size[u];
        par[u] = v;
    }
    connectedComponent--;
    return true;
}