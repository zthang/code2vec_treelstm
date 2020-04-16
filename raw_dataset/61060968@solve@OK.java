void solve() {
    n = in.nextInt();
    int m = in.nextInt();
    graph = new boolean[n][n];
    for (int i = 0; i < m; i++) {
        int from = in.nextInt() - 1, to = in.nextInt() - 1;
        graph[from][to] = graph[to][from] = true;
    }
    p = new int[n];
    dominos = new boolean[7][7];
    go(0);
    out.println(ans);
}