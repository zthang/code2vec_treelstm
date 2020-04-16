public void solve(int testNumber, InputReader c, OutputWriter w) {
    int t = c.readInt();
    while (t-- > 0) {
        int n = c.readInt(), m = c.readInt();
        p[] a = new p[n];
        for (int i = 0; i < n; i++) {
            int u = c.readInt();
            a[i] = new p(u, i + 1);
        }
        if (n > m || n == 2) {
            w.printLine("-1");
            continue;
        }
        Arrays.sort(a);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += a[i].a;
            res += a[(i + 1) % n].a;
        }
        for (int i = n; i < m; i++) {
            res += a[0].a;
            res += a[1].a;
        }
        w.printLine(res);
        for (int i = 0; i < n; i++) {
            w.printLine(a[i].b, a[(i + 1) % n].b);
        }
        for (int i = n; i < m; i++) {
            w.printLine(a[0].b, a[1].b);
        }
    }
}