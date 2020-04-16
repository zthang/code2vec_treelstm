// if modulo is required set value accordingly
public static long[][] matrixMultiply2dL(long[][] t, long[][] m) {
    long[][] res = new long[t.length][m[0].length];
    for (int i = 0; i < t.length; i++) {
        for (int j = 0; j < m[0].length; j++) {
            res[i][j] = 0;
            for (int k = 0; k < t[0].length; k++) {
                res[i][j] += t[i][k] + m[k][j];
            }
        }
    }
    return res;
}