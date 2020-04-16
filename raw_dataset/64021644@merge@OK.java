public void merge(int a, int b) {
    int rootA = getRoot(a);
    int rootB = getRoot(b);
    if (rootA == rootB) {
        return;
    }
    if (ranks[rootA] < ranks[rootB]) {
        parents[rootA] = rootB;
    } else if (ranks[rootB] < ranks[rootA]) {
        parents[rootB] = rootA;
    } else {
        parents[rootA] = rootB;
        ranks[rootB]++;
    }
}