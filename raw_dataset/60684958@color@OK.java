static void color(int u, List<List<Edge>> adj, int[] status) {
    status[u] = ACTIVE;
    for (Edge e : adj.get(u)) {
        if (status[e.to] == ACTIVE) {
            colors = 2;
            e.color = BLACK;
        } else {
            e.color = WHITE;
            if (status[e.to] == FRESH)
                color(e.to, adj, status);
        }
    }
    status[u] = DONE;
}