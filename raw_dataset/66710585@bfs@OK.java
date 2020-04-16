static void bfs(int h, int n) {
    Queue<Integer> q = new LinkedList<Integer>();
    int[] dist = new int[n];
    Arrays.fill(dist, INF);
    for (int i = 0; i < n; i++) {
        if (arr[i] % 2 == h) {
            q.add(i);
            dist[i] = 0;
        }
    }
    while (!q.isEmpty()) {
        int cur = q.poll();
        for (int x : adjList[cur]) {
            if (dist[x] == INF) {
                dist[x] = dist[cur] + 1;
                q.add(x);
            }
        }
    }
    for (int i = 0; i < n; i++) {
        if (arr[i] % 2 != h) {
            ans[i] = dist[i] == INF ? -1 : dist[i];
        }
    }
}