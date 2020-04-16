public static void bfs(int x, int y) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(x * N + y);
    while (!q.isEmpty()) {
        int cur = q.poll();
        x = cur / N;
        y = cur % N;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx == -1 || nx == N || ny == -1 || ny == N || X[x][y] != X[nx][ny] || Y[x][y] != Y[nx][ny] || grid[nx][ny] != 0) {
                continue;
            }
            grid[nx][ny] = dir[i];
            q.offer(nx * N + ny);
        }
    }
}