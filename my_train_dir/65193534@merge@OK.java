public void merge(int a, int b) {
    int rootA = getRoot(a);
    int rootB = getRoot(b);
    int maxA = getMax(a);
    int maxB = getMax(b);
    int max = Math.max(maxA, maxB);
    if (rootA == rootB) {
        return;
    }
    if (ranks[rootA] < ranks[rootB]) {
        parents[rootA] = rootB;
        maxs[rootB] = max;
    } else if (ranks[rootB] < ranks[rootA]) {
        parents[rootB] = rootA;
        maxs[rootA] = max;
    } else {
        parents[rootA] = rootB;
        ranks[rootB]++;
        maxs[rootB] = max;
    }
}