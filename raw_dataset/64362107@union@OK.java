void union(int u, int v, long cost) {
    int x = root(u), y = root(v);
    if (x == y)
        return;
    if (c[par[x]] + c[par[y]] <= cost + Math.min(c[par[x]], c[par[y]]))
        return;
    if (sz[x] > sz[y]) {
        int tmp = x;
        x = y;
        y = tmp;
    }
    sz[y] += sz[x];
    F[x] = y;
    par[y] = (c[par[x]] < c[par[y]] ? par[x] : par[y]);
    sm[y] += sm[x] + cost;
    ans.add(new Node(u, v, cost));
}