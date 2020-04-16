int[] bfs(int start) {
    boolean[] visited = new boolean[n + 1];
    Deque<Integer> q = new LinkedList<>();
    q.offer(start);
    int[] res = new int[n + 1];
    Arrays.fill(res, INF);
    int dist = 0;
    while (!q.isEmpty()) {
        for (int T = q.size(); T > 0; --T) {
            int v = q.poll();
            visited[v] = true;
            res[v] = dist;
            for (int u : g[v]) if (!visited[u]) {
                visited[u] = true;
                q.offer(u);
            }
        }
        dist++;
    }
    return res;
}