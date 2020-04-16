static void solve(int p) {
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; i++) if (a[i] % 2 == p) {
        dist[p][i] = 0;
        q.add(i);
    }
    while (!q.isEmpty()) {
        int u = q.remove();
        for (int v : adjList[u]) {
            if (dist[p][v] == -1) {
                dist[p][v] = 1 + dist[p][u];
                q.add(v);
            }
        }
    }
}