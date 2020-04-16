int get(int u) {
    return p[u] == u ? u : (p[u] = get(p[u]));
}