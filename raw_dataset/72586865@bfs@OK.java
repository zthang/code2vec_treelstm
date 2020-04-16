private static boolean bfs(int pos) {
    int r = pos / grid.length, c = pos % grid.length;
    grid[r][c] = 'X';
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] { r, c });
    int cnt = 1, total = xCnt.get(pos);
    while (!q.isEmpty() && cnt < total) {
        int[] curr = q.poll();
        for (int i = 0; i < 4; i++) {
            int x = curr[0] + dx[i];
            int y = curr[1] + dy[i];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid.length && stop[x][y][0] == r && stop[x][y][1] == c && grid[x][y] == '*') {
                grid[x][y] = revDir[i];
                q.add(new int[] { x, y });
                cnt++;
            }
        }
    }
    return cnt == total;
}