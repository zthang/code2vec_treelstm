private void paintX(int i, int j, int n, int[][] x, int[][] y, char[][] result, int[] quei, int[] quej) {
    if (x[i][j] == i && y[i][j] == j) {
        int queh = 0;
        result[i][j] = X;
        quei[queh] = i;
        quej[queh] = j;
        queh++;
        while (queh > 0) {
            queh--;
            int u = quei[queh];
            int v = quej[queh];
            for (int d = 0; d < DX.length; d++) {
                int ii = u + DX[d];
                int jj = v + DY[d];
                if (ii >= 0 && ii < n && jj >= 0 && jj < n) {
                    if (x[ii][jj] == x[u][v] && y[ii][jj] == y[u][v]) {
                        if (result[ii][jj] == 0) {
                            result[ii][jj] = DN[(d + 2) % DX.length];
                            quei[queh] = ii;
                            quej[queh] = jj;
                            queh++;
                        }
                    }
                }
            }
        }
    }
}