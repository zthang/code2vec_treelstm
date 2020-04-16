static void decompose(int u, int lb) {
    end = 0;
    comp = new Compressor();
    int maxSize = getSize(u, -1, lb);
    u = getCentroid(u, -1, maxSize);
    depth[u] = lb;
    maxSize = Math.max(maxSize, comp.fix() + 1);
    tot = new int[maxSize + 1];
    equal = new int[maxSize + 1];
    addAll(u);
    for (int i = head[u]; i != -1; i = next[i]) {
        Edge e = to[i];
        if (depth[e.to] == -1) {
            clear(e.to, u, e.cost);
            computeDist(e.to, u, e.cost);
            add(e.to, u, e.cost, false);
        }
    }
    for (int i = head[u]; i != -1; i = next[i]) {
        Edge e = to[i];
        if (depth[e.to] == -1)
            decompose(e.to, lb + 1);
    }
}