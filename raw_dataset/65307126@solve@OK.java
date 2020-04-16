public void solve(int testNumber, FastReader s, PrintWriter w) {
    int n = s.nextInt(), m = s.nextInt(), ans = 0;
    dsu d = new dsu(n);
    while (m-- > 0) {
        d.unite(s.nextInt() - 1, s.nextInt() - 1);
    }
    TreeMap<Integer, Integer> t = new TreeMap<>();
    for (int i = 0; i < n; i++) {
        int par = d.getPar(i);
        if (!t.containsKey(par)) {
            if (!t.isEmpty())
                ans++;
            if (d.sz[par] > 1)
                t.put(par, d.sz[par] - 1);
        } else {
            if (t.get(par) == 1)
                t.remove(par);
            else
                t.replace(par, t.get(par) - 1);
        }
    }
    w.println(ans);
}