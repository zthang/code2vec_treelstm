public static boolean traverse_2(int[][] f, char[][] ans, int p, int q) {
    int n = ans.length;
    if (p - 1 >= 0) {
        // UP
        if (f[p - 1][q] == -1) {
            if (ans[p - 1][q] == 'N') {
                ans[p - 1][q] = 'D';
                cnt++;
            }
            ans[p][q] = 'U';
            cnt++;
            return true;
        }
    }
    if (p + 1 < n) {
        // DOWN
        if (f[p + 1][q] == -1) {
            if (ans[p + 1][q] == 'N') {
                ans[p + 1][q] = 'U';
                cnt++;
            }
            ans[p][q] = 'D';
            cnt++;
            return true;
        }
    }
    if (q - 1 >= 0) {
        // LEFT
        if (f[p][q - 1] == -1) {
            if (ans[p][q - 1] == 'N') {
                ans[p][q - 1] = 'R';
                cnt++;
            }
            ans[p][q] = 'L';
            cnt++;
            return true;
        }
    }
    if (q + 1 < n) {
        // RIGHT
        if (f[p][q + 1] == -1) {
            if (ans[p][q + 1] == 'N') {
                ans[p][q + 1] = 'L';
                cnt++;
            }
            ans[p][q] = 'R';
            cnt++;
            return true;
        }
    }
    return false;
}