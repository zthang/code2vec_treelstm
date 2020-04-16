private void solve(InputReader in, PrintWriter out) {
    final int k = in.nextInt();
    final int n = 2 * k;
    Graphs.Edge[] edges = new Graphs.Edge[n - 1];
    List<Integer>[] adj = new List[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < n - 1; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        int t = in.nextInt();
        edges[i] = new Graphs.Edge(a, b, t);
        adj[a].add(i);
        adj[b].add(i);
    }
    Pair<Long, Long> answer = both(edges, adj);
    out.println(Util.join(answer.first, answer.second));
}