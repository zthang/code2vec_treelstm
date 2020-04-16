void solve() {
    int n = in.nextInt();
    int m = in.nextInt();
    g = new boolean[n][n];
    id = new int[n];
    for (int i = 0; i < m; i++) {
        int fr = in.nextInt() - 1;
        int to = in.nextInt() - 1;
        g[fr][to] = g[to][fr] = true;
    }
    out.println(go(0));
}