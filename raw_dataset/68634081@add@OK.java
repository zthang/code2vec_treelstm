void add(int u, int v, int w) {
    to[ct] = v;
    // wt[ct] = w;
    ne[ct] = h[u];
    h[u] = ct++;
}