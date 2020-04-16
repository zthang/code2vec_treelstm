void add(int u, int v) {
    u--;
    v--;
    to[ct] = v;
    ne[ct] = h[u];
    h[u] = ct++;
}