int singleSource(int n, int[][][] end, List<int[]> sameEnd, int sR, int sC, char[][] res, boolean[][] vis) {
    List<int[]> cur = new LinkedList<>(), next = new LinkedList<>();
    cur.add(new int[] { sR, sC });
    vis[sR][sC] = true;
    res[sR][sC] = 'X';
    while (cur.size() > 0) {
        for (int[] now : cur) {
            int r0 = now[0], c0 = now[1];
            // look upwards
            for (int k = 0; k < 4; k++) {
                int r = r0 + dr[k], c = c0 + dc[k];
                if (r < 0 || r >= n || c < 0 || c >= n || vis[r][c])
                    continue;
                if (end[r][c][0] != sR || end[r][c][1] != sC)
                    continue;
                vis[r][c] = true;
                next.add(new int[] { r, c });
                res[r][c] = dirFrom[k];
            }
        }
        cur = next;
        next = new LinkedList<>();
    }
    for (int[] cell : sameEnd) {
        if (!vis[cell[0]][cell[1]])
            return -1;
    }
    return 1;
}