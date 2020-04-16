public void solve(int testNumber, FastScanner in, PrintWriter out) {
    int n = in.nextInt();
    int numQueries = in.nextInt();
    Graph g = new Graph(n);
    for (int i = 0; i < n - 1; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        g.addEdge(a, b);
        g.addEdge(b, a);
    }
    LCA lca = new LCA(g);
    for (int query = 0; query < numQueries; query++) {
        int k = in.nextInt();
        Integer[] vs = new Integer[k];
        for (int i = 0; i < k; i++) {
            vs[i] = in.nextInt() - 1;
            if (vs[i] != 0) {
                vs[i] = lca.ancestor[0][vs[i]];
            }
        }
        Arrays.sort(vs, (u, v) -> (lca.depth[u] - lca.depth[v]));
        boolean ans = true;
        for (int i = 0; i + 1 < k; i++) {
            if (!lca.isAncestor(vs[i], vs[i + 1])) {
                ans = false;
                break;
            }
        }
        out.println(ans ? "YES" : "NO");
    }
}