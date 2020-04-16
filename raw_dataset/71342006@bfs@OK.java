private static int bfs(List<Integer>[] g, int src, int dest) {
    Queue<Integer> q = new LinkedList<>();
    q.add(src);
    boolean[] visited = new boolean[g.length];
    visited[src] = true;
    int dist = 0;
    boolean reach = false;
    while (q.size() > 0) {
        int sz = q.size();
        for (int i = 0; i < sz; i++) {
            int curr = q.poll();
            if (curr == dest) {
                reach = true;
                break;
            }
            for (int next : g[curr]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        if (reach) {
            break;
        }
        dist++;
    }
    return dist;
}