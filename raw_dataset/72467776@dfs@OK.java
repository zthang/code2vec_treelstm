void dfs(int x, int y) {
    vis[x][y] = true;
    if (x + 1 < n && !vis[x + 1][y] && p[x + 1][y].equals(par)) {
        ans[x + 1][y] = 'U';
        dfs(x + 1, y);
    }
    if (x - 1 >= 0 && !vis[x - 1][y] && p[x - 1][y].equals(par)) {
        ans[x - 1][y] = 'D';
        dfs(x - 1, y);
    }
    if (y + 1 < n && !vis[x][y + 1] && p[x][y + 1].equals(par)) {
        ans[x][y + 1] = 'L';
        dfs(x, y + 1);
    }
    if (y - 1 >= 0 && !vis[x][y - 1] && p[x][y - 1].equals(par)) {
        ans[x][y - 1] = 'R';
        dfs(x, y - 1);
    }
}