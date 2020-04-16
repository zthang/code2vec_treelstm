private static void fromSourceBfs(List<Integer>[] g) {
    Queue<Integer> q = new LinkedList<>();
    q.add(0);
    boolean[] visited = new boolean[g.length];
    visited[0] = true;
    int dist = 0;
    while (q.size() > 0) {
        int sz = q.size();
        for (int i = 0; i < sz; i++) {
            int curr = q.poll();
            fromSourceSp[curr] = dist;
            for (int next : g[curr]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        dist++;
    }
}