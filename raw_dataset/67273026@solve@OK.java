public void solve(int testNumber, InputReader c, OutputWriter w) {
    int n = c.readInt();
    int[] a = new int[2 * n + 1];
    for (int i = 0; i < n; i++) {
        int l = c.readInt(), r = c.readInt();
        a[l] = l;
        a[r] = -l;
    }
    // w.printLine(Arrays.toString(a));
    UnionFind dsu = new UnionFind(2 * n + 1);
    TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());
    int cnt = n - 1;
    for (int i = 1; i <= 2 * n; i++) {
        if (a[i] > 0) {
            ts.add(a[i]);
        } else {
            a[i] = -a[i];
            ts.remove(a[i]);
            for (int k : ts) {
                if (k < a[i]) {
                    break;
                } else if (dsu.connected(a[i], k)) {
                    w.printLine("NO");
                    return;
                } else {
                    dsu.unify(a[i], k);
                    cnt--;
                }
            }
        }
    }
    // w.printLine(cnt);
    if (cnt == 0) {
        w.printLine("YES");
    } else {
        w.printLine("NO");
    }
}