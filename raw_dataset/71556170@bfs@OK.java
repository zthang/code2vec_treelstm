static void bfs(int[] dist, int src) {
    LinkedList<Integer> queue = new LinkedList<>();
    queue.add(src);
    boolean[] vis = new boolean[dist.length];
    vis[src] = true;
    while (!queue.isEmpty()) {
        int node = queue.remove();
        for (int i : ll[node]) {
            if (!vis[i]) {
                vis[i] = true;
                queue.add(i);
                dist[i] = dist[node] + 1;
            }
        }
    }
}