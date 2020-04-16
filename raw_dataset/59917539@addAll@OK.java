static void addAll(int u) {
    for (Edge e : adjList[u]) if (depth[e.to] == -1)
        add(e.to, u, e.cost, true);
}