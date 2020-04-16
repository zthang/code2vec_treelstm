private static int[][] getSparseTable(int[] array, BinaryOperator<Integer> binaryOperator) {
    int k = log[array.length + 1] + 1;
    int[][] st = new int[array.length + 1][k + 1];
    for (int i = 0; i < array.length; i++) st[i][0] = array[i];
    for (int j = 1; j <= k; j++) {
        for (int i = 0; i + (1 << j) <= array.length; i++) {
            st[i][j] = binaryOperator.apply(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
        }
    }
    return st;
}