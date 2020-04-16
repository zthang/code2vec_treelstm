private long calc(Graph g, int x, int y) {
    boolean[] was = new boolean[g.n];
    dfs(g, x, y, was);
    int res = 0;
    for (int i = 0; i < was.length; i++) {
        if (!was[i]) {
            ++res;
        }
    }
    return res;
}