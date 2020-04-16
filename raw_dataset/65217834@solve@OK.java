public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    DisjointSetsRank orig = new DisjointSetsRank(n);
    DisjointSetsRank modified = new DisjointSetsRank(n);
    int m = in.nextInt();
    for (int i = 0; i < m; i++) {
        int u = in.nextInt(), v = in.nextInt();
        u--;
        v--;
        // System.out.println(u + " " + v);
        orig.unite(u, v);
        modified.unite(u, v);
    }
    ArrayList<Long> intervals = new ArrayList<>();
    for (int i = 0; i < n; i++) if (orig.getParent(i) == i) {
        intervals.add(get(orig.getMinNode(i) + 1, orig.getMaxNode(i)));
    }
    // System.out.println(orig.root(0) + " " + orig.root(3));
    Collections.sort(intervals);
    int L = 0, R = -1;
    for (long x : intervals) {
        int l = getL(x) - 1, r = getR(x) - 1;
        // System.out.println(l + " " + r);
        if (l > r)
            continue;
        if (l > R) {
            for (int i = L; i <= R; i++) modified.unite(i, i + 1);
            L = l;
            R = r;
        } else
            R = Integer.max(R, r);
    }
    for (int i = L; i <= R; i++) modified.unite(i, i + 1);
    out.println(orig.getComponents() - modified.getComponents());
}