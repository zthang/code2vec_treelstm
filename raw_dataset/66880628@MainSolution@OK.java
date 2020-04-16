static void MainSolution() {
    n = ni();
    ArrayList<Integer>[] adj = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
    int[] ar = new int[n + 1];
    int[] dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    for (int i = 1; i <= n; i++) ar[i] = ni();
    LinkedList<Integer> q = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
        int x = ar[i];
        int y = x;
        if (i + x <= n) {
            y = ar[i + x];
            adj[i + x].add(i);
            if (((x ^ y) & 1) == 1) {
                dist[i] = 1;
                q.add(i);
            }
        }
        if (i - x >= 1) {
            y = ar[i - x];
            adj[i - x].add(i);
            if (((x ^ y) & 1) == 1) {
                dist[i] = 1;
                q.add(i);
            }
        }
    }
    while (!q.isEmpty()) {
        int x = q.poll();
        for (int y : adj[x]) {
            if (dist[y] == Integer.MAX_VALUE) {
                dist[y] = min(dist[y], dist[x] + 1);
                q.add(y);
            }
        }
    }
    for (int i = 1; i <= n; i++) p(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
    pl();
}