public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    g = Graph.build(in, n, m, false);
    vs = new TreeSet<>();
    for (int i = 1; i <= n; ++i) vs.add(i);
    int ans = 0;
    for (int i = 1; i <= n; ++i) if (vs.contains(i)) {
        ans++;
        bfs(i);
    }
    out.println(ans - 1);
}