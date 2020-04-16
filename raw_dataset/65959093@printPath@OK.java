public static void printPath(boolean ch, int i, int j, long[][][] dp) {
    if (ch) {
        if (i == 0 && j == 0)
            return;
        else if (i - 1 < 0) {
            solve.append("R");
            printPath(true, i, j - 1, dp);
        } else if (j - 1 < 0) {
            solve.append("D");
            printPath(true, i - 1, j, dp);
        } else {
            if (dp[i][j][0] >= dp[i - 1][j][0]) {
                solve.append("D");
                printPath(true, i - 1, j, dp);
            } else {
                solve.append("R");
                printPath(true, i, j - 1, dp);
            }
        }
    } else {
        if (i == 0 && j == 0)
            return;
        else if (i - 1 < 0) {
            solve.append("R");
            printPath(false, i, j - 1, dp);
        } else if (j - 1 < 0) {
            solve.append("D");
            printPath(false, i - 1, j, dp);
        } else {
            if (dp[i][j][1] >= dp[i - 1][j][1]) {
                solve.append("D");
                printPath(false, i - 1, j, dp);
            } else {
                solve.append("R");
                printPath(false, i, j - 1, dp);
            }
        }
    }
}