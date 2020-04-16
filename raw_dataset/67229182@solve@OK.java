void solve() {
    n = in.nextInt();
    for (int i = 0; i < n; i++) al.add(new pair(in.nextInt(), in.nextInt()));
    Collections.sort(al, (A, B) -> A.F == B.F ? B.S - A.S : A.F - B.F);
    for (int i = 1; i <= n; i++) p[i] = i;
    boolean tree = true;
    o: for (int i = 0; i < al.size(); i++) {
        pair p = al.get(i);
        for (Iterator it = ts.tailSet(new pair(p.F + 1, -1)).iterator(); it.hasNext(); ) {
            pair p1 = (pair) it.next();
            if (p1.F >= p.S)
                break;
            if (!merge(i + 1, p1.S)) {
                tree = false;
                break o;
            }
        }
        ts.add(new pair(p.S, i + 1));
    }
    tree &= (ed == (n - 1));
    out.print(tree ? "YES" : "NO");
}