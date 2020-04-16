public void bfs(int cur) {
    Queue<Integer> q = new LinkedList<>();
    q.add(cur);
    visited[cur] = true;
    while (!q.isEmpty()) {
        cur = q.poll();
        for (Integer v : con[cur]) {
            if (!visited[v]) {
                visited[v] = true;
                q.add(v);
            }
        }
    }
}