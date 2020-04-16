static int bfs(char[][] ch, int i, int j) {
    Queue<aksh> q = new LinkedList<>();
    q.add(new aksh(i, j));
    int[][] dis = new int[h][w];
    int[][] vis = new int[h][w];
    vis[i][j] = 1;
    dis[i][j] = 0;
    while (!q.isEmpty()) {
        aksh arr = q.poll();
        int x1 = arr.x;
        int y1 = arr.y;
        if ((x1 - 1) >= 0 && ch[x1 - 1][y1] != '#' && vis[x1 - 1][y1] == 0) {
            vis[x1 - 1][y1] = 1;
            q.add(new aksh(x1 - 1, y1));
            dis[x1 - 1][y1] = Math.max(dis[x1 - 1][y1], dis[x1][y1] + 1);
        }
        if ((x1 + 1) < h && ch[x1 + 1][y1] != '#' && vis[x1 + 1][y1] == 0) {
            vis[x1 + 1][y1] = 1;
            dis[x1 + 1][y1] = Math.max(dis[x1 + 1][y1], dis[x1][y1] + 1);
            q.add(new aksh(x1 + 1, y1));
        }
        if ((y1 - 1) >= 0 && ch[x1][y1 - 1] != '#' && vis[x1][y1 - 1] == 0) {
            vis[x1][y1 - 1] = 1;
            dis[x1][y1 - 1] = Math.max(dis[x1][y1 - 1], dis[x1][y1] + 1);
            q.add(new aksh(x1, y1 - 1));
        }
        if ((y1 + 1) < w && ch[x1][y1 + 1] != '#' && vis[x1][y1 + 1] == 0) {
            vis[x1][y1 + 1] = 1;
            dis[x1][y1 + 1] = Math.max(dis[x1][y1 + 1], dis[x1][y1] + 1);
            q.add(new aksh(x1, y1 + 1));
        }
    }
    int max = Integer.MIN_VALUE;
    for (int x = 0; x < h; x++) {
        for (int y = 0; y < w; y++) max = Math.max(dis[x][y], max);
    }
    return max;
}