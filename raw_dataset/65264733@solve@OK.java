public void solve() throws QuickAnswer {
    long[] d = getDist();
    weight = new long[g.edgeFrom.length];
    for (int i = 0; i < g.edgeFrom.length; i++) {
        weight[i] = g.edgeWeight[i] + d[g.edgeFrom[i]] + d[g.edgeTo[i]];
    }
    Integer[] order = new Integer[g.edgeFrom.length];
    for (int i = 0; i < order.length; i++) {
        order[i] = i;
    }
    Arrays.sort(order, Comparator.comparingLong(i -> weight[i]));
    qs = new HashSet[g.n];
    root = new int[g.n];
    for (int i = 0; i < g.n; i++) {
        root[i] = i;
    }
    for (int i = 0; i < q; i++) {
        if (qs[a[i]] == null)
            qs[a[i]] = new HashSet<>();
        qs[a[i]].add(i);
        if (qs[b[i]] == null)
            qs[b[i]] = new HashSet<>();
        qs[b[i]].add(i);
    }
    for (int pos : order) {
        union(g.edgeFrom[pos], g.edgeTo[pos], weight[pos]);
    }
    for (long i : res) {
        println(i);
    }
}