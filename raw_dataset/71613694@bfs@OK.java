static void bfs(int start, int[] dist, int n) {
    Queue<Integer> q = new LinkedList<Integer>();
    for (int i = 0; i < n; i++) {
        dist[i] = -1;
    }
    q.add(start);
    dist[start] = 0;
    while (!q.isEmpty()) {
        int x = q.poll();
        for (int i = 0; i < graph[x].size(); i++) {
            int y = graph[x].get(i);
            if (dist[y] == -1) {
                dist[y] = dist[x] + 1;
                q.add(y);
            }
        }
    }
}