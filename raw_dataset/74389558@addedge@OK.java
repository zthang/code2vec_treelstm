void addedge(int u, int v) {
    adjlist.get(u).add(v);
    adjlist.get(v).add(u);
}