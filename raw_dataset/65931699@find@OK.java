public int find(int i) {
    int p = parent[i];
    if (i == p) {
        return i;
    }
    return parent[i] = find(p);
}