public void solve(int testNumber, InputReader c, OutputWriter w) {
    int n = c.readInt(), m = c.readInt();
    UnionFind dsu = new UnionFind(n);
    for (int i = 0; i < m; i++) {
        int u = c.readInt() - 1, v = c.readInt() - 1;
        dsu.unify(u, v);
    }
    TreeMap<Integer, Integer> tm = new TreeMap<>();
    int res = 0;
    for (int i = 0; i < n; i++) {
        int y = dsu.find(i);
        if (!tm.containsKey(y)) {
            if (!tm.isEmpty()) {
                res++;
            }
            if (dsu.componentSize(y) > 1) {
                tm.put(y, dsu.componentSize(y) - 1);
            }
        } else {
            if (tm.get(y) == 1) {
                tm.remove(y);
            } else {
                tm.replace(y, tm.get(y) - 1);
            }
        }
    }
    w.printLine(res);
}