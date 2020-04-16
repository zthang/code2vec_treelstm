private void dfsTree(int i, int[] u, RootedTree r) {
    u[i] = 1;
    for (Edge e : list[i]) {
        if (u[e.to] == 0) {
            r.list[i].add(e);
            u[e.to] = 1;
            dfsTree(e.to, u, r);
        }
    }
}