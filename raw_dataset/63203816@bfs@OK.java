static void bfs(int s, List<List<Integer>> adj, boolean[] match, boolean[] happy, int k) {
    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(s);
    match[s] = true;
    while (!deque.isEmpty()) {
        int u = deque.pollLast();
        for (int v : adj.get(u)) {
            if (!match[v]) {
                match[v] = true;
                if (u < k)
                    happy[u] = true;
                deque.addFirst(v);
            }
        }
    }
}