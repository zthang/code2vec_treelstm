private void solveE() throws IOException {
    int n = in.nextInt(), m = in.nextInt();
    long[] w = in.nextLongArray(n);
    long sumW = sumLong(w);
    graph = in.nextGraph(n, m, false);
    int s = in.nextInt() - 1;
    long[] maxAdd = new long[n];
    boolean[] deleted = new boolean[n];
    int[] cnt = new int[n];
    int[] q = new int[n];
    int ql = 0, qr = 0;
    for (int v = 0; v < n; v++) {
        if ((cnt[v] = graph[v].size()) == 1 && v != s) {
            q[qr++] = v;
        }
    }
    while (ql < qr) {
        int v = q[ql++];
        sumW -= w[v];
        deleted[v] = true;
        int cntr = 0;
        for (int u : graph[v]) {
            if (!deleted[u]) {
                cntr++;
                maxAdd[u] = max(maxAdd[u], maxAdd[v] + w[v]);
                if (--cnt[u] == 1 && u != s) {
                    q[qr++] = u;
                }
            }
        }
        if (cntr != 1)
            n = 1 / 0;
    }
    long cur = 0, ans = 0;
    for (int v = 0; v < n; v++) {
        if (!deleted[v])
            ans = max(ans, cur + sumW + maxAdd[v]);
    }
    out.println(ans);
}