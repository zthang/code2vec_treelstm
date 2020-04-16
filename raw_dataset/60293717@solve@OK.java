void solve() {
    int n = ni();
    Pair[] p = new Pair[n + 1];
    for (int i = 1; i <= n; i++) {
        p[i] = new Pair(i, ni());
    }
    Arrays.sort(p, 1, n + 1);
    ArrayList<Pair> ans = new ArrayList<>();
    for (int i = 1; i < n; i++) {
        ans.add(new Pair(2 * p[i].id - 1, 2 * p[i + 1].id - 1));
    }
    int[] a = new int[2 * n + 1];
    for (int i = 1; i <= n; i++) a[i] = 2 * p[i].id - 1;
    int sz = n;
    for (int i = 1; i <= n; i++) {
        if (i + p[i].d - 1 == sz) {
            a[++sz] = 2 * p[i].id;
            ans.add(new Pair(a[sz - 1], a[sz]));
        } else {
            ans.add(new Pair(2 * p[i].id, a[i + p[i].d - 1]));
        }
    }
    for (Pair pp : ans) pw.println(pp.id + " " + pp.d);
}