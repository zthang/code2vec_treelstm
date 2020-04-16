static void clear(int u, int p, int dist) {
    update(comp.get(dist), -1, tot);
    update(comp.get(dist), -1, equal);
    for (int i = head[u]; i != -1; i = next[i]) {
        Edge e = to[i];
        if (e.to != p && depth[e.to] == -1)
            clear(e.to, u, Math.max(dist, e.cost));
    }
}