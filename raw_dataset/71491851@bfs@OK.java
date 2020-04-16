static void bfs(int ind, int n, int[] dist) {
    boolean[] vis = new boolean[n + 1];
    dist[ind] = 0;
    vis[ind] = true;
    Queue<Integer> q = new LinkedList<>();
    q.add(ind);
    while (!q.isEmpty()) {
        int a = q.poll();
        for (int i : map.get(a)) {
            if (!vis[i]) {
                dist[i] = dist[a] + 1;
                q.add(i);
                vis[i] = true;
            }
        }
    }
}