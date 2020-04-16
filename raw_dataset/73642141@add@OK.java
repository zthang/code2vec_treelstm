public void add(int u, int v) {
    ar[u].add(v);
    ar[v].add(u);
}