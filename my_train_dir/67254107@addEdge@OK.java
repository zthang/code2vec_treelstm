public void addEdge(int p, int q) {
    nbs[p].add(q);
    nbs[q].add(p);
}