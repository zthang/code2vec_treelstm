static void dfs(int x, int y, char c) {
    // already fiiled
    if (a[x][y] != '\0' && c != 'X')
        return;
    a[x][y] = c;
    // check for neighbors with same val
    if (mat[x - 1][y][0] == mat[x][y][0] && mat[x - 1][y][1] == mat[x][y][1])
        dfs(x - 1, y, 'D');
    if (mat[x + 1][y][0] == mat[x][y][0] && mat[x + 1][y][1] == mat[x][y][1])
        dfs(x + 1, y, 'U');
    if (mat[x][y - 1][0] == mat[x][y][0] && mat[x][y - 1][1] == mat[x][y][1])
        dfs(x, y - 1, 'R');
    if (mat[x][y + 1][0] == mat[x][y][0] && mat[x][y + 1][1] == mat[x][y][1])
        dfs(x, y + 1, 'L');
}