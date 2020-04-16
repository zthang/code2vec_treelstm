int get(int u) {
    return pa[u] == u ? u : (pa[u] = get(pa[u]));
}