public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();
    int[] W = in.readIntArray(n);
    int[] U = new int[m], V = new int[m];
    in.readIntArrays(U, V);
    MiscUtils.decreaseByOne(U, V);
    IntSet[] graph = new IntSet[n];
    Arrays.setAll(graph, i -> new IntHashSet());
    for (int i = 0; i < m; i++) {
        graph[U[i]].add(V[i]);
        graph[V[i]].add(U[i]);
    }
    int s = in.readInt() - 1;
    long res = ArrayUtils.sumArray(W) - bfs(graph, s, W);
    out.printLine(res);
}