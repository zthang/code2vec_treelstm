public int find(int x) {
    if (size[x] == 0)
        size[x] = 1;
    if (parent[x] == x) {
        return x;
    } else {
        return parent[x] = find(parent[x]);
    }
}