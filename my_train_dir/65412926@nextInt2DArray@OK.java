public int[][] nextInt2DArray(int m, int n) throws IOException {
    int[][] arr = new int[m][n];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) arr[i][j] = nextInt();
    }
    return arr;
}