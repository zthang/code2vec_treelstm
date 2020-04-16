static void bfs(Pair p) {
    Queue<Pair> q = new LinkedList<>();
    q.add(p);
    while (!q.isEmpty()) {
        Pair u = q.poll();
        for (int i = 0; i < 4; i++) {
            int nr = u.r + dx[i], nc = u.c + dy[i];
            if (valid(nr, nc) && grid[nr][nc] == -1) {
                if (adj[nr][nc].r == adj[u.r][u.c].r && adj[nr][nc].c == adj[u.r][u.c].c) {
                    grid[nr][nc] = (i + 2) % 4;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }
}