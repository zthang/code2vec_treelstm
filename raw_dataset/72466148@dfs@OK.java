static boolean dfs(int i, int j, int ip, int jp) {
    if (vis[i][j]) {
        q.add(new pair(i, j, x[i][j], y[i][j]));
        vis1[i][j] = true;
        return true;
    }
    vis[i][j] = true;
    for (int o = 0; o < 4; o++) {
        int nx = dx[o] + i;
        int ny = dy[o] + j;
        if (!v1(nx, ny))
            continue;
        boolean f = dfs(nx, ny, i, j);
        if (f) {
            q.add(new pair(i, j, x[i][j], y[i][j]));
            if (dx[o] == 1) {
                grid[nx][ny] = 'U';
            }
            if (dx[o] == -1) {
                grid[nx][ny] = 'D';
            }
            if (dy[o] == 1) {
                grid[nx][ny] = 'L';
            }
            if (dy[o] == -1) {
                grid[nx][ny] = 'R';
            }
            vis1[nx][ny] = true;
            return true;
        }
    }
    return false;
}