static void clear(int u, int p, int dist) {
    update(comp.get(dist), -1, tot);
    update(comp.get(dist), -1, equal);
    for (Edge e : adjList[u]) if (e.to != p && depth[e.to] == -1)
        clear(e.to, u, Math.max(dist, e.cost));
}