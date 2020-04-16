public static void dfs(char ch, int i, int j) {
    if (i < 1 && j < 1 && i > n && j > n)
        return;
    if (ans[i][j] == '\u0000')
        ans[i][j] = ch;
    else
        return;
    if (i > 1) {
        if (arr[i - 1][j] == arr[i][j] && brr[i - 1][j] == brr[i][j]) {
            dfs('D', i - 1, j);
        }
    }
    if (j > 1) {
        if (arr[i][j - 1] == arr[i][j] && brr[i][j - 1] == brr[i][j]) {
            dfs('R', i, j - 1);
        }
    }
    if (i < n) {
        if (arr[i + 1][j] == arr[i][j] && brr[i + 1][j] == brr[i][j]) {
            dfs('U', i + 1, j);
        }
    }
    if (j < n) {
        if (arr[i][j + 1] == arr[i][j] && brr[i][j + 1] == brr[i][j]) {
            dfs('L', i, j + 1);
        }
    }
}