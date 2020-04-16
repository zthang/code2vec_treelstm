void add(int u, int v) {
    to[ct] = u;
    ne[ct] = h[v];
    h[v] = ct++;
}