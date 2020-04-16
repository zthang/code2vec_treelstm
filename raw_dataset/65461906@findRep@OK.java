public int findRep(int x) {
    if (parent[x] != x) {
        parent[x] = findRep(parent[x]);
    }
    return parent[x];
}