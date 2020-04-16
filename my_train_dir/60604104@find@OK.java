static int find(int v) {
    if (v == id[v]) {
        return v;
    }
    id[v] = find(id[v]);
    return id[v];
}