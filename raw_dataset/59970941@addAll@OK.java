static void addAll(int u) {
    for (int i = head[u]; i != -1; i = next[i]) {
        Edge e = to[i];
        if (depth[e.to] == -1)
            add(e.to, u, e.cost, true);
    }
}