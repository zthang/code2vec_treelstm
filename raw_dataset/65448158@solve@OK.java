private void solve(InputReader in, PrintWriter out) {
    int n = in.nextInt(), m = in.nextInt();
    int[] a = in.readIntArray(n);
    List<Pair<Integer, Integer>> edges = findEdges(a, m);
    if (edges == null) {
        out.println(-1);
        return;
    }
    int cost = findCost(a, edges);
    out.println(cost);
    for (Pair<Integer, Integer> e : edges) {
        out.println(Util.join(e.first + 1, e.second + 1));
    }
    Util.ASSERT(verifyDegrees(n, m, edges));
    Util.ASSERT(cost == findTheoreticalMin(a, m));
}