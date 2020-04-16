public void cycle(Cell c) {
    for (int i = 0; i < 4; i++) {
        int x = c.i + dx[i], y = c.j + dy[i];
        if (x >= 0 && x < N && y >= 0 && y < N && a[x][y].endx == c.endx && a[x][y].endy == c.endy && a[x][y].direction == ' ') {
            a[x][y].direction = dir[i];
            dfs(a[x][y]);
        }
    }
}