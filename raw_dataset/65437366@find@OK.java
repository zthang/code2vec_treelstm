static int find(int i) {
    if (parent[i] == i)
        return i;
    return parent[i] = find(parent[i]);
}