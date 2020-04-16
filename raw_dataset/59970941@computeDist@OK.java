static void computeDist(int u, int p, int dist) {
    ans[dist]++;
    ans[dist] += query(comp.get(dist - 1), tot);
    ans[dist] += rsq(comp.get(dist), comp.get(dist), equal);
    for (int i = head[u]; i != -1; i = next[i]) {
        Edge e = to[i];
        if (e.to != p && depth[e.to] == -1)
            computeDist(e.to, u, Math.max(dist, e.cost));
    }
}