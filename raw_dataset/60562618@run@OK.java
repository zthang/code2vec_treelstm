public void run(FastScanner sc, FastPrinter out) throws Exception {
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[][] adj = sc.readGraph(N, M, true, true);
    boolean[] vis = new boolean[N];
    int sat = 0;
    for (int i = 0; i < N; i++) {
        if (vis[i])
            continue;
        int size = dfs(i, vis, adj);
        sat += size - 1;
    }
    out.println(M - sat);
}