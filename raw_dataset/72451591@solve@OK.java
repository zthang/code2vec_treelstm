private char[][] solve(int n, int[][] x, int[][] y) {
    char[][] result = new char[n][n];
    int[] quei = new int[n * n];
    int[] quej = new int[n * n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (result[i][j] == 0) {
                if (x[i][j] == -1 && y[i][j] == -1) {
                    paintInf(i, j, n, x, y, result);
                } else {
                    paintX(x[i][j], y[i][j], n, x, y, result, quei, quej);
                }
                if (result[i][j] == 0) {
                    return null;
                }
            }
        }
    }
    return result;
}