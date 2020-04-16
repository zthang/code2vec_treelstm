void add_edge(int u, int v) {
    adj.get(u).add(v);
    adj.get(v).add(u);
}