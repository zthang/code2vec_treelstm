static void dfsLoop(int x, int y) {
    if (ans[x][y] != 0) {
        return;
    }
    if (x - 1 >= 0 && a[x - 1][y].isLoop()) {
        ans[x][y] = 'U';
    } else if (x + 1 < n && a[x + 1][y].isLoop()) {
        ans[x][y] = 'D';
    } else if (y - 1 >= 0 && a[x][y - 1].isLoop()) {
        ans[x][y] = 'L';
    } else if (y + 1 < n && a[x][y + 1].isLoop()) {
        ans[x][y] = 'R';
    } else {
        return;
    }
    end = a[x][y];
    dfs(x, y);
}