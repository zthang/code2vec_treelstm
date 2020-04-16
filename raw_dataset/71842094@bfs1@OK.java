static void bfs1(int root) {
    Queue<Integer> q = new LinkedList<Integer>();
    vis[root] = 1;
    q.add(root);
    while (!q.isEmpty()) {
        root = q.poll();
        for (int i = 0; i < g[root].size(); i++) {
            int child = g[root].get(i);
            if (vis[child] == 0) {
                vis[child] = 1;
                dist[child] = dist[root] + 1;
                q.add(child);
            }
        }
    }
}