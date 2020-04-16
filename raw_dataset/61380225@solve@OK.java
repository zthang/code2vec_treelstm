void solve(int TestCase, InputReader in, PrintWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    while (m-- > 0) {
        int u = in.nextInt();
        int v = in.nextInt();
        u--;
        v--;
        g[u][v] = g[v][u] = true;
    }
    gen(0);
    out.println(ans);
}