static void bfs2(int root) {
    Queue<Integer> q = new LinkedList<Integer>();
    vis1[root] = 1;
    q.add(root);
    while (!q.isEmpty()) {
        root = q.poll();
        for (int i = 0; i < g[root].size(); i++) {
            int child = g[root].get(i);
            if (vis1[child] == 0) {
                vis1[child] = 1;
                dist1[child] = dist1[root] + 1;
                q.add(child);
            }
        }
    }
}