public void solve(int testNumber, InputReader in, PrintWriter out) {
    int N = in.nextInt();
    int k = in.nextInt();
    int T = (int) (1e4);
    boolean[] part = new boolean[N];
    long[][] adj = new long[N][N];
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            adj[i][j] = in.nextInt();
        }
    }
    long res = INF;
    while (T-- > 0) {
        setPartition(part);
        res = Math.min(res, findMin(part, adj, k));
    }
    out.println(res);
}