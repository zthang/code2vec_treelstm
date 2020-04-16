static void dfs(int s, List<List<Edge>> adj, int[] status, int[] next) {
    LinkedList<Integer> stack = new LinkedList<>();
    stack.add(s);
    while (!stack.isEmpty()) {
        int u = stack.pollLast();
        if (status[u] == FRESH)
            status[u] = ACTIVE;
        if (next[u] >= adj.get(u).size()) {
            status[u] = DONE;
            continue;
        }
        Edge e = adj.get(u).get(next[u]);
        next[u]++;
        if (status[e.to] == ACTIVE) {
            colors = 2;
            e.color = BLACK;
        } else {
            e.color = WHITE;
            if (status[e.to] == FRESH) {
                stack.addLast(u);
                stack.addLast(e.to);
            }
        }
    }
}