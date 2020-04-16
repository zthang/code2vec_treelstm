public void unite(int a, int b) {
    int rootA = findRoot(a);
    int rootB = findRoot(b);
    if (rootA == rootB)
        return;
    if (size[rootA] > size[rootB]) {
        parent[rootB] = rootA;
        size[rootA] += size[rootB];
    } else {
        parent[rootA] = rootB;
        size[rootB] += size[rootA];
    }
}