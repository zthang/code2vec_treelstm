static void dfs(int s, List<List<Edge>> adj, int[] status, int[] next) {
    LinkedList<Integer> stack = new LinkedList<>();
    stack.add(s);
    status[s] = ACTIVE;
    while (!stack.isEmpty()) {
        int u = stack.peekLast();
        if (next[u] >= adj.get(u).size()) {
            stack.pollLast();
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
                status[e.to] = ACTIVE;
                stack.addLast(e.to);
            }
        }
    }
}