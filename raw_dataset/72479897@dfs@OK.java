private static void dfs(int[][][] matrix, char[][] dirs, int i, int j, int startI, int startJ) {
    if (i - 1 >= 0) {
        if (matrix[i - 1][j][0] == startI + 1 && matrix[i - 1][j][1] == startJ + 1) {
            if (dirs[i - 1][j] < 'A') {
                dirs[i - 1][j] = 'D';
                dfs(matrix, dirs, i - 1, j, startI, startJ);
            }
        }
    }
    if (j - 1 >= 0) {
        if (matrix[i][j - 1][0] == startI + 1 && matrix[i][j - 1][1] == startJ + 1) {
            if (dirs[i][j - 1] < 'A') {
                dirs[i][j - 1] = 'R';
                dfs(matrix, dirs, i, j - 1, startI, startJ);
            }
        }
    }
    if (i + 1 < matrix.length) {
        if (matrix[i + 1][j][0] == startI + 1 && matrix[i + 1][j][1] == startJ + 1) {
            if (dirs[i + 1][j] < 'A') {
                dirs[i + 1][j] = 'U';
                dfs(matrix, dirs, i + 1, j, startI, startJ);
            }
        }
    }
    if (j + 1 < matrix.length) {
        if (matrix[i][j + 1][0] == startI + 1 && matrix[i][j + 1][1] == startJ + 1) {
            if (dirs[i][j + 1] < 'A') {
                dirs[i][j + 1] = 'L';
                dfs(matrix, dirs, i, j + 1, startI, startJ);
            }
        }
    }
}