private void bfs(int start) {
    Deque<Integer> q = new ArrayDeque<>();
    q.offer(start);
    vs.remove(start);
    List<Integer> next = new ArrayList<>();
    while (!q.isEmpty()) {
        next.clear();
        int v = q.poll();
        for (int u : vs) if (!g[v].contains(u)) {
            next.add(u);
        }
        for (int x : next) {
            q.add(x);
            vs.remove(x);
        }
    }
}