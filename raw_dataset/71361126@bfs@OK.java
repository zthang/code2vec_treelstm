public static <T extends DirectedEdge> void bfs(List<T>[] g, int s, int[] dist, int inf, IntegerDeque deque) {
    Arrays.fill(dist, inf);
    dist[s] = 0;
    deque.clear();
    deque.addLast(s);
    while (!deque.isEmpty()) {
        int head = deque.removeFirst();
        for (T e : g[head]) {
            if (dist[e.to] == inf) {
                dist[e.to] = dist[head] + 1;
                deque.addLast(e.to);
            }
        }
    }
}