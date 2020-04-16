static int find(int i) {
    if (i == parent[i])
        return i;
    parent[i] = find(parent[i]);
    return parent[i];
}