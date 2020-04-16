private void paintInf(int i, int j, int n, int[][] x, int[][] y, char[][] result) {
    for (int d = 0; d < DX.length; d++) {
        int ii = i + DX[d];
        int jj = j + DY[d];
        if (ii < 0 || ii >= n || jj < 0 || jj >= n) {
            continue;
        }
        if (x[ii][jj] == -1 && y[ii][jj] == -1) {
            result[i][j] = DN[d];
            return;
        }
    }
}