void dfs(int x, int y, int stx, int sty) {
    if (valid(x, y + 1, stx, sty)) {
        s[x][y + 1] = 'L';
        dfs(x, y + 1, stx, sty);
    }
    if (valid(x, y - 1, stx, sty)) {
        s[x][y - 1] = 'R';
        dfs(x, y - 1, stx, sty);
    }
    if (valid(x + 1, y, stx, sty)) {
        s[x + 1][y] = 'U';
        dfs(x + 1, y, stx, sty);
    }
    if (valid(x - 1, y, stx, sty)) {
        s[x - 1][y] = 'D';
        dfs(x - 1, y, stx, sty);
    }
}