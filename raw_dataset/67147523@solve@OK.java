public void solve(int testNumber, InputReader c, OutputWriter w) {
    int n = c.readInt();
    int m = c.readInt();
    Pair<Long, Integer>[] bal = new Pair[n];
    for (int i = 0; i < n; i++) {
        bal[i] = new Pair<>(0L, i);
    }
    for (int i = 0; i < m; i++) {
        int u = c.readInt() - 1, v = c.readInt() - 1, cost = c.readInt();
        bal[u].u -= cost;
        bal[v].u += cost;
    }
    Arrays.sort(bal);
    // w.printLine(Arrays.toString(bal));
    ArrayList<res> ans = new ArrayList<>();
    int neg = 0, pos = n - 1;
    while (bal[neg].u < 0) {
        while (bal[pos].u > 0) {
            long cst = Math.min(Math.abs(bal[neg].u), bal[pos].u);
            bal[neg].u += cst;
            bal[pos].u -= cst;
            ans.add(new res(bal[neg].v + 1, bal[pos].v + 1, cst));
            if (bal[neg].u == 0) {
                neg++;
            }
        }
        pos--;
    }
    w.printLine(ans.size());
    for (res l : ans) {
        w.printLine(l);
    }
}