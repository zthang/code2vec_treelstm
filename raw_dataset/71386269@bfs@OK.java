int[] bfs(int start) {
    boolean[] visited = new boolean[n + 1];
    Deque<Integer> q = new LinkedList<>();
    q.offer(start);
    int[] res = new int[n + 1];
    Arrays.fill(res, INF);
    res[start] = 0;
    while (!q.isEmpty()) {
        int v = q.poll();
        visited[v] = true;
        for (int u : g[v]) if (!visited[u]) {
            res[u] = res[v] + 1;
            visited[u] = true;
            q.offer(u);
        }
    }
    return res;
}