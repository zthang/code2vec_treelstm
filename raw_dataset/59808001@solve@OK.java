public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int k = in.readInt();
    int[] p = in.readIntArray(n);
    int[] q = in.readIntArray(n);
    MiscUtils.decreaseByOne(p, q);
    Graph g = new Graph(n);
    for (int i = 0; i < n - 1; i++) {
        g.addSimpleEdge(p[i], p[i + 1]);
        g.addSimpleEdge(q[i], q[i + 1]);
    }
    Pair<int[], Graph> kosaraju = StronglyConnectedComponents.kosaraju(g);
    int size = kosaraju.second.vertexCount();
    if (size < k) {
        out.printLine("NO");
        return;
    }
    out.printLine("YES");
    for (int i = 0; i < n; i++) {
        out.print((char) ('a' + Math.min(kosaraju.first[i], k - 1)));
    }
    out.printLine();
}