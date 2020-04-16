boolean ddffss(int i, int j) {
    vis[i][j] = 1;
    if (i - 1 >= 1 && a[i - 1][j].f == -1 && a[i - 1][j].s == -1) {
        ans[i][j] = 'U';
        return true;
    }
    if (j - 1 >= 1 && a[i][j - 1].f == -1 && a[i][j - 1].s == -1) {
        ans[i][j] = 'L';
        return true;
    }
    if (i + 1 <= n && a[i + 1][j].f == -1 && a[i + 1][j].s == -1) {
        vis[i + 1][j] = 1;
        ans[i][j] = 'D';
        ans[i + 1][j] = 'U';
        return true;
    }
    if (j + 1 <= n && a[i][j + 1].f == -1 && a[i][j + 1].s == -1) {
        vis[i][j + 1] = 1;
        ans[i][j] = 'R';
        ans[i][j + 1] = 'L';
        return true;
    }
    return false;
}