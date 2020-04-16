private static void bfs(int color) {
    Q q = new Q(2 * R * C);
    for (int r = 0; r < R; r++) {
        for (int c = 0; c < C; c++) {
            if (grid[r][c] == color) {
                cost[color][r][c] = 0;
                q.add(r);
                q.add(c);
            }
        }
    }
    boolean[] done = new boolean[K];
    while (!q.isEmpty()) {
        int pr = q.remove();
        int pc = q.remove();
        if (!done[grid[pr][pc]]) {
            done[grid[pr][pc]] = true;
            for (int i = 0; i < colorCells[grid[pr][pc]].size(); i += 2) {
                int nr = colorCells[grid[pr][pc]].get(i);
                int nc = colorCells[grid[pr][pc]].get(i + 1);
                if (cost[color][nr][nc] == -1) {
                    cost[color][nr][nc] = cost[color][pr][pc] + 1;
                    q.add(nr);
                    q.add(nc);
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            int nr = pr + dr[i], nc = pc + dc[i];
            if (nr >= 0 && nr < R && nc >= 0 && nc < C && cost[color][nr][nc] == -1) {
                cost[color][nr][nc] = cost[color][pr][pc] + 1;
                q.add(nr);
                q.add(nc);
            }
        }
    }
}