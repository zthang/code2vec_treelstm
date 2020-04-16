public static void Bfs(int curr, int[] x) {
    LinkedList<Integer> q = new LinkedList<Integer>();
    int n = adj.length;
    boolean[] visited = new boolean[n];
    visited[curr] = true;
    q.add(curr);
    x[curr] = 0;
    while (!q.isEmpty()) {
        int top = q.removeFirst();
        for (Integer y : adj[top]) {
            if (!visited[y]) {
                visited[y] = true;
                x[y] = x[top] + 1;
                q.add(y);
            }
        }
    }
}