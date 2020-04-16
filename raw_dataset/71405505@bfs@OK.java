private static void bfs(int[] dis, int node) {
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) visited[i] = false;
    q.add(node);
    dis[node] = 0;
    visited[node] = true;
    while (!q.isEmpty()) {
        int curr = q.poll();
        for (int child : graph.get(curr)) {
            if (!visited[child]) {
                q.add(child);
                visited[child] = true;
                dis[child] = dis[curr] + 1;
            }
        }
    }
}