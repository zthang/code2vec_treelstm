static int findParent(int x) {
    if (parent[x] == x) {
        return x;
    }
    return parent[x] = findParent(parent[x]);
}