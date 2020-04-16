public void bfs(int[] dist, int s) {
    boolean[] vis = new boolean[n];
    Queue<Integer> q = new LinkedList<>();
    Arrays.fill(dist, 1000000);
    dist[s] = 0;
    q.add(s);
    while (!q.isEmpty()) {
        int r = q.poll();
        if (vis[r])
            continue;
        vis[r] = true;
        for (int x : a[r]) {
            if (!vis[x]) {
                // System.out.println("in" + dist[x] + " " + dist[r]);
                q.add(x);
                dist[x] = Math.min(dist[x], dist[r] + 1);
            }
        }
    }
}