private static int[][] getSparseTable(int[] array) {
    int k = log[MAXN] + 1;
    int[][] st = new int[MAXN][k + 1];
    for (int i = 0; i < array.length; i++) st[i][0] = array[i];
    for (int j = 1; j <= k; j++) {
        for (int i = 0; i + (1 << j) <= array.length; i++) {
            st[i][j] = Math.max(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
        }
    }
    return st;
}