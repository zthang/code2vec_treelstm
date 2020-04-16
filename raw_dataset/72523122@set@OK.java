public static boolean set(int i, int j) {
    boolean flag = false;
    if (i > 1) {
        if (arr[i - 1][j] == -1) {
            if (ans[i][j] == '\u0000')
                ans[i][j] = 'U';
            if (ans[i - 1][j] == '\u0000')
                ans[i - 1][j] = 'D';
            flag = true;
        }
    }
    if (j > 1) {
        if (arr[i][j - 1] == -1) {
            if (ans[i][j] == '\u0000')
                ans[i][j] = 'L';
            if (ans[i][j - 1] == '\u0000')
                ans[i][j - 1] = 'R';
            flag = true;
        }
    }
    if (i < n) {
        if (arr[i + 1][j] == -1) {
            if (ans[i][j] == '\u0000')
                ans[i][j] = 'D';
            if (ans[i + 1][j] == '\u0000')
                ans[i + 1][j] = 'U';
            flag = true;
        }
    }
    if (j < n) {
        if (arr[i][j + 1] == -1) {
            if (ans[i][j] == '\u0000')
                ans[i][j] = 'R';
            if (ans[i][j + 1] == '\u0000')
                ans[i][j + 1] = 'L';
            flag = true;
        }
    }
    return flag;
}