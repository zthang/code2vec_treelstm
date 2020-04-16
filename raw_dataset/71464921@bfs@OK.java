static void bfs(int idx, int start) {
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    dist[idx][start] = 0;
    while (!q.isEmpty()) {
        int cur = q.remove();
        for (int next : adjList[cur]) {
            if (dist[idx][next] == -1) {
                dist[idx][next] = dist[idx][cur] + 1;
                q.add(next);
            }
        }
    }
}