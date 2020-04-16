int[][] logstepParents(int[] parent) {
    int n = parent.length;
    int m = Integer.numberOfTrailingZeros(Integer.highestOneBit(n - 1)) + 1;
    int[][] sparse = new int[m][n];
    sparse[0] = parent;
    for (int j = 1; j < m; j++) {
        for (int i = 0; i < n; i++) {
            sparse[j][i] = sparse[j - 1][i] == -1 ? -1 : sparse[j - 1][sparse[j - 1][i]];
        }
    }
    return sparse;
}