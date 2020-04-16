static int find_set(int v) {
    if (v == snm[v]) {
        return v;
    }
    return snm[v] = find_set(snm[v]);
}