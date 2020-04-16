static void dfs(int x, int y) {
    if ((x - 1 >= 0) && (a[x - 1][y].equals(end)) && (ans[x - 1][y] == 0)) {
        ans[x - 1][y] = 'D';
        dfs(x - 1, y);
    }
    if ((x + 1 < n) && (a[x + 1][y].equals(end)) && (ans[x + 1][y] == 0)) {
        ans[x + 1][y] = 'U';
        dfs(x + 1, y);
    }
    if ((y - 1 >= 0) && (a[x][y - 1].equals(end)) && (ans[x][y - 1] == 0)) {
        ans[x][y - 1] = 'R';
        dfs(x, y - 1);
    }
    if ((y + 1 < n) && (a[x][y + 1].equals(end)) && (ans[x][y + 1] == 0)) {
        ans[x][y + 1] = 'L';
        dfs(x, y + 1);
    }
}