public void solve(int testNumber, InputReader c, OutputWriter w) {
    HashMap<Integer, Integer> size = new HashMap<>();
    int n = c.readInt(), m = c.readInt();
    p3[] edge = new p3[n - 1];
    for (int i = 0; i < n - 1; i++) {
        edge[i] = new p3(c.readInt() - 1, c.readInt() - 1, c.readInt());
    }
    for (int i = 0; i < n; i++) {
        size.put(i, 1);
    }
    Arrays.sort(edge);
    UnionFind dsu = new UnionFind(n);
    pair[] queries = new pair[m];
    for (int i = 0; i < m; i++) {
        queries[i] = new pair(c.readInt(), i);
    }
    Arrays.sort(queries);
    int j = 0;
    long res = 0;
    long[] ans = new long[m];
    for (int i = 0; i < m; i++) {
        while (j < n - 1 && edge[j].w <= queries[i].x) {
            int xroot = dsu.find(edge[j].x), yroot = dsu.find(edge[j].y);
            res -= nc2(dsu.componentSize(xroot));
            res -= nc2(dsu.componentSize(yroot));
            dsu.unify(edge[j].x, edge[j].y);
            res += nc2(dsu.componentSize(xroot));
            j++;
        }
        ans[i] = res;
    }
    long[] seq = new long[m];
    for (int i = 0; i < m; i++) {
        seq[queries[i].y] = ans[i];
    }
    w.printLine(seq);
}