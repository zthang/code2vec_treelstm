public static void traverse(int[][] f, char[][] ans, int p, int q) {
    int n = ans.length;
    if (p - 1 >= 0) {
        // UP
        if (f[p][q] == f[p - 1][q] && ans[p - 1][q] == 'N') {
            ans[p - 1][q] = 'D';
            cnt++;
            traverse(f, ans, p - 1, q);
        }
    }
    if (p + 1 < n) {
        // DOWN
        if (f[p][q] == f[p + 1][q] && ans[p + 1][q] == 'N') {
            ans[p + 1][q] = 'U';
            cnt++;
            traverse(f, ans, p + 1, q);
        }
    }
    if (q - 1 >= 0) {
        // LEFT
        if (f[p][q] == f[p][q - 1] && ans[p][q - 1] == 'N') {
            ans[p][q - 1] = 'R';
            cnt++;
            traverse(f, ans, p, q - 1);
        }
    }
    if (q + 1 < n) {
        // RIGHT
        if (f[p][q] == f[p][q + 1] && ans[p][q + 1] == 'N') {
            ans[p][q + 1] = 'L';
            cnt++;
            traverse(f, ans, p, q + 1);
        }
    }
}