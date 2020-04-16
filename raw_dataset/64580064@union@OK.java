void union(int a, int b) {
    int rootA = root(a);
    int rootB = root(b);
    if (rootA == rootB)
        return;
    if (sz[rootA] > sz[rootB]) {
        int tmp = rootA;
        rootA = rootB;
        rootB = tmp;
    }
    F[rootA] = rootB;
    sz[rootB] += sz[rootA];
}