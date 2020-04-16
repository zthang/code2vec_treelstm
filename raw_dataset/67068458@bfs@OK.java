static void bfs() {
    while (!q.isEmpty()) {
        int curr = q.poll();
        if (hmap.containsKey(curr)) {
            for (int x : hmap.get(curr)) {
                if (!vis[x]) {
                    dist[x] = min(dist[x], dist[curr] + 1);
                    q.add(x);
                    vis[x] = true;
                }
            }
        }
    }
}