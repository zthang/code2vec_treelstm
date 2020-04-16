public void merge(int u, int parent) {
    if (find(u) == find(parent))
        return;
    p[find(u)] = find(parent);
}