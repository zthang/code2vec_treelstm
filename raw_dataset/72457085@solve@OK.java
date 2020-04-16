public static void solve(int i, int j) {
    valid[i][j] = true;
    for (int k = 0; k < 4; k++) {
        int nx = dx[k] + i;
        int ny = dy[k] + j;
        if (ny >= 0 && nx >= 0 && ny < ans.length && nx < ans.length) {
            if (ans[nx][ny] == 0 && x[nx][ny] == x[i][j] && y[nx][ny] == y[i][j]) {
                ans[nx][ny] = m[k ^ 1];
                solve(nx, ny);
            }
        }
    }
}