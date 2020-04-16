private void connect(int u, int v) {
    int u0 = find(u);
    int v0 = find(v);
    if (u0 == v0)
        return;
    p[u0] = v0;
    size[v0] += size[u0];
    nextTo[v0] |= nextTo[u0];
}