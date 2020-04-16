static void bfs(PriorityQueue<pair> pq) {
    while (!pq.isEmpty()) {
        pair p = pq.poll();
        int x = p.y;
        for (int i = 0; i < adj[x].size(); i++) {
            int idx = (int) adj[x].get(i);
            if (!visited[idx]) {
                ans[idx] = ans[x] + 1;
                pq.add(new pair(ans[idx], idx));
                visited[idx] = true;
            }
        }
    }
}