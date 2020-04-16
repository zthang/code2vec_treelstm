void add_edge(int x, int y) {
    to[++tot] = y;
    nx[tot] = h[x];
    h[x] = tot;
    to[++tot] = x;
    nx[tot] = h[y];
    h[y] = tot;
    rk[x]++;
    rk[y]++;
}