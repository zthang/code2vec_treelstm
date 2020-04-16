void add(int u, int v, long ww) {
    to[++cc] = u;
    // w[cc] = ww;
    ne[cc] = h[v];
    h[v] = cc;
    to[++cc] = v;
    // w[cc] = ww;
    ne[cc] = h[u];
    h[u] = cc;
}