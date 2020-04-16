public void solve() {
    int n = io.readInt();
    int m = io.readInt();
    int last = 0;
    DynamicConnectionChecker checker = new DynamicConnectionChecker(n, m);
    for (int i = 0; i < m; i++) {
        int op = io.readInt();
        int x = (io.readInt() + last - 1) % n;
        int y = (io.readInt() + last - 1) % n;
        if (op == 1) {
            if (checker.containEdge(x, y)) {
                checker.deleteEdge(x, y);
            } else {
                checker.addEdge(x, y);
            }
        } else {
            last = checker.check(x, y) ? 1 : 0;
            io.cache.append(last);
        }
    }
}