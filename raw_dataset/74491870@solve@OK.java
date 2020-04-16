public void solve(int testNumber, FastReader s, PrintWriter w) {
    int n = s.nextInt(), m = s.nextInt();
    ArrayList<Integer>[] a = new ArrayList[n];
    for (int i = 0; i < n; i++) a[i] = new ArrayList<>();
    for (int i = 1; i < n; i++) {
        int u = s.nextInt() - 1, v = s.nextInt() - 1;
        a[u].add(v);
        a[v].add(u);
    }
    LCA l = new LCA(n, a);
    l.build(0);
    while (m-- > 0) {
        int k = s.nextInt(), mx = -1, v = -1;
        int[] ver = new int[k];
        for (int i = 0; i < k; i++) {
            ver[i] = s.nextInt() - 1;
            if (l.lvl[ver[i]] > mx) {
                mx = l.lvl[ver[i]];
                v = ver[i];
            }
        }
        boolean ok = true;
        for (int i : ver) if (i != v)
            if (l.dist(0, i) + l.dist(i, v) > l.dist(0, v) + 2)
                ok = false;
        w.println(ok ? "YES" : "NO");
    }
}