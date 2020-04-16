public void solve(int testNumber, FastReader s, PrintWriter w) {
    int n = s.nextInt(), k = s.nextInt();
    ArrayList<Integer>[] a = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        a[i] = new ArrayList<>();
    }
    dsu d = new dsu(n);
    for (int i = 0; i < k; i++) {
        int x = s.nextInt() - 1, y = s.nextInt() - 1;
        d.unite(x, y);
    }
    int tot = 0;
    boolean[] b = new boolean[n];
    for (int i = 0; i < n; i++) {
        int root = d.getPar(i);
        if (!b[root]) {
            tot += d.getSize(root) - 1;
            b[root] = true;
        }
    }
    w.println(k - tot);
}