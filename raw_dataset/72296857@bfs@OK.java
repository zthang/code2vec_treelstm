void bfs(int s, int[] dist) {
    boolean[] visited = new boolean[V];
    Arrays.fill(visited, false);
    LinkedList<Integer> q = new LinkedList<>();
    q.add(s);
    visited[s] = true;
    while (!q.isEmpty()) {
        int x = q.poll();
        Iterator<Integer> ir = ar[x].iterator();
        while (ir.hasNext()) {
            int val = ir.next();
            if (!visited[val]) {
                q.add(val);
                visited[val] = true;
                dist[val] = dist[x] + 1;
            }
        }
    }
}