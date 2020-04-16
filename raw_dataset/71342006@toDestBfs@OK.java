private static void toDestBfs(List<Integer>[] g) {
    Queue<Integer> q = new LinkedList<>();
    q.add(g.length - 1);
    boolean[] visited = new boolean[g.length];
    visited[g.length - 1] = true;
    int dist = 0;
    while (q.size() > 0) {
        int sz = q.size();
        for (int i = 0; i < sz; i++) {
            int curr = q.poll();
            toDestSp[curr] = dist;
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