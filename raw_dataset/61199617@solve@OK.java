public void solve(int testNumber, InputReader sc, PrintWriter out) throws IOException {
    int n = sc.nextInt();
    int m = sc.nextInt();
    for (int i = 0; i < m; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        edge.add(new Node(u, v));
    }
    dfs(n);
    out.println(ans);
}