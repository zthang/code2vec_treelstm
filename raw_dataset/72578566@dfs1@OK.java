private void dfs1(int x, int y, int rx, int ry, boolean[][] vis) {
    vis[x][y] = true;
    for (int i = 0; i < 4; i++) {
        int nx = x + dir[i][0], ny = y + dir[i][1];
        if (nx < 0 || nx >= n || ny < 0 || ny >= n || A[nx][ny][0] != rx || A[nx][ny][1] != ry || vis[nx][ny])
            continue;
        if (i == 0) {
            ret[nx][ny] = 'L';
        } else if (i == 1) {
            ret[nx][ny] = 'U';
        } else if (i == 2) {
            ret[nx][ny] = 'D';
        } else {
            ret[nx][ny] = 'R';
        }
        dfs1(nx, ny, rx, ry, vis);
    }
}