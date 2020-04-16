static void solve(int k) {
    q.clear();
    anyToAny[k][k] = 1;
    for (int r = 0; r < R; r++) {
        for (int c = 0; c < C; c++) {
            if (col[r][c] == k) {
                closestCol[k][r][c] = 0;
                q.add(r);
                q.add(c);
            }
        }
    }
    while (!q.isEmpty()) {
        int r = q.poll();
        int c = q.poll();
        for (int kk = 0; kk < 4; kk++) {
            int nr = r + dr[kk];
            int nc = c + dc[kk];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C || closestCol[k][nr][nc] != -1)
                continue;
            closestCol[k][nr][nc] = closestCol[k][r][c] + 1;
            anyToAny[k][col[nr][nc]] = min(anyToAny[k][col[nr][nc]], 1 + closestCol[k][nr][nc]);
            q.add(nr);
            q.add(nc);
        }
    }
}