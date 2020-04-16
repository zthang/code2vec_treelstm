int find(int v) {
    if (p[v] == v) {
        return v;
    }
    return p[v] = find(p[v]);
}