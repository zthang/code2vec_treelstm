public void solve(int testNumber, FastReader s, PrintWriter w) {
    int n = s.nextInt();
    pair<Integer, Integer>[] p = new pair[n << 1], segs = new pair[n];
    for (int i = 0; i < n; i++) {
        segs[i] = new pair<>(s.nextInt(), s.nextInt());
        p[i << 1] = new pair<>(segs[i].x, i);
        p[i << 1 | 1] = new pair<>(segs[i].y, i);
    }
    Arrays.sort(p);
    TreeSet<pair<Integer, Integer>> t = new TreeSet<>();
    dsu d = new dsu(n);
    boolean ok = true;
    for (pair<Integer, Integer> seg : p) {
        if (t.contains(seg))
            t.remove(seg);
        else {
            int last = segs[seg.y].y, cur = seg.y;
            for (pair<Integer, Integer> pp : t) {
                if (pp.x > last)
                    break;
                ok = d.unite(cur, pp.y);
                if (!ok)
                    break;
            }
            if (!ok)
                break;
            t.add(new pair<>(last, cur));
        }
    }
    w.println(ok && d.con == 1 ? "YES" : "NO");
}