static boolean dfs(int r, int c) {
    for (int i = 0; i < 4; i++) {
        int nr = r + dx[i], nc = c + dy[i];
        if (valid(nr, nc) && adj[nr][nc].r == -2) {
            grid[r][c] = i;
            return true;
        }
    }
    return false;
}