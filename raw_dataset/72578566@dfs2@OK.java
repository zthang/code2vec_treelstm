private void dfs2(int x, int y, boolean[][] vis) {
    vis[x][y] = true;
    for (int i = 0; i < 4; i++) {
        int nx = x + dir[i][0], ny = y + dir[i][1];
        if (nx < 0 || nx >= n || ny < 0 || ny >= n || vis[nx][ny])
            continue;
        if (i == 0) {
            ret[nx][ny] = 'L';
            if (ret[x][y] == 'N')
                ret[x][y] = 'R';
        } else if (i == 1) {
            ret[nx][ny] = 'U';
            if (ret[x][y] == 'N')
                ret[x][y] = 'D';
        } else if (i == 2) {
            ret[nx][ny] = 'D';
            if (ret[x][y] == 'N')
                ret[x][y] = 'U';
        } else {
            ret[nx][ny] = 'R';
            if (ret[x][y] == 'N')
                ret[x][y] = 'L';
        }
        dfs2(nx, ny, vis);
    }
}