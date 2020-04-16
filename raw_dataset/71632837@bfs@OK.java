private void bfs(int start, int[] parent, int[] distance) {
    Queue<Integer> q = new LinkedList<Integer>();
    int[] vis = new int[V];
    vis[start] = 1;
    q.add(start);
    while (!q.isEmpty()) {
        int v = q.poll();
        for (int adj : graph[v]) {
            if (vis[adj] == 0) {
                q.add(adj);
                vis[adj] = 1;
                parent[adj] = v;
                distance[adj] = distance[v] + 1;
            }
        }
    }
}