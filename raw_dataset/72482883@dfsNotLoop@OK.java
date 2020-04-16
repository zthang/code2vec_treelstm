static void dfsNotLoop(int x, int y) {
    if ((a[x][y].x == x) && (a[x][y].y == y) && (ans[x][y] == 0)) {
        ans[x][y] = 'X';
        end = a[x][y];
        dfs(x, y);
    }
}