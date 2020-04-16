void dfs(int i, int j, int x, int y) {
    vis[i][j] = 1;
    k++;
    if (i + 1 <= n && vis[i + 1][j] == 0 && a[i + 1][j].f == x && a[i + 1][j].s == y) {
        dfs(i + 1, j, x, y);
        ans[i + 1][j] = 'U';
    }
    if (j + 1 <= n && vis[i][j + 1] == 0 && a[i][j + 1].f == x && a[i][j + 1].s == y) {
        dfs(i, j + 1, x, y);
        ans[i][j + 1] = 'L';
    }
    if (i - 1 >= 1 && vis[i - 1][j] == 0 && a[i - 1][j].f == x && a[i - 1][j].s == y) {
        dfs(i - 1, j, x, y);
        ans[i - 1][j] = 'D';
    }
    if (j - 1 >= 1 && vis[i][j - 1] == 0 && a[i][j - 1].f == x && a[i][j - 1].s == y) {
        dfs(i, j - 1, x, y);
        ans[i][j - 1] = 'R';
    }
}