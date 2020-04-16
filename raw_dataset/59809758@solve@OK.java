public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int m = in.readInt();
    List<List<Edge>> edges = new ArrayList<>();
    for (int i = 0; i <= 200000; i++) {
        edges.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
        int from = in.readInt() - 1;
        int to = in.readInt() - 1;
        int cost = in.readInt();
        edges.get(cost).add(new Edge(from, to));
    }
    int[] q = in.readIntArray(m);
    long[] ans = new long[200001];
    long sum = 0;
    UnionFind uf = new UnionFind(n);
    for (int i = 0; i <= 200000; i++) {
        for (Edge e : edges.get(i)) {
            long size1 = uf.size(e.from);
            long size2 = uf.size(e.to);
            sum -= size1 * (size1 - 1) / 2;
            sum -= size2 * (size2 - 1) / 2;
            uf.union(e.from, e.to);
            sum += (size1 + size2) * (size1 + size2 - 1) / 2;
        }
        ans[i] = sum;
    }
    for (int i = 0; i < m; i++) {
        if (i > 0)
            out.print(" ");
        out.print(ans[q[i]]);
    }
    out.printLine();
}