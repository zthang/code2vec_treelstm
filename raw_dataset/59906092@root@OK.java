int root(int u) {
    return c[u] < 0 ? u : (c[u] = root(c[u]));
}