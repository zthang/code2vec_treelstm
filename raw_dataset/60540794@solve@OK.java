public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    boolean[] u = new boolean[n];
    DisjointSets dsu = new DisjointSets(n);
    for (int i = 0; i < m; ++i) {
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        u[x] = true;
        u[y] = true;
        if (dsu.root(x) != dsu.root(y)) {
            dsu.unite(x, y);
        }
    }
    int res = m;
    for (int i = 0; i < n; ++i) {
        if (u[i]) {
            --res;
            if (dsu.root(i) == i) {
                ++res;
            }
        }
    }
    out.printLine(res);
}