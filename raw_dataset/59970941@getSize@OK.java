static int getSize(int u, int p, int lb) {
    size[u] = 1;
    for (int i = head[u]; i != -1; i = next[i]) {
        Edge e = to[i];
        if (e.to != p && depth[e.to] == -1) {
            size[u] += getSize(e.to, u, lb);
            comp.add(e.cost, lb);
            comp.add(e.cost - 1, lb);
        }
    }
    return size[u];
}