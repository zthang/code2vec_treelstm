private static void bfs(int[] distances, int src) {
    Queue<Integer> q = new LinkedList<>();
    q.add(src);
    boolean[] visited = new boolean[distances.length];
    visited[src] = true;
    int distance = 0;
    while (q.size() > 0) {
        int sz = q.size();
        for (int i = 0; i < sz; i++) {
            int curr = q.poll();
            distances[curr] = distance;
            for (int next : g[curr]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        distance++;
    }
}