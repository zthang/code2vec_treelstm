private void solveE() throws IOException {
    int n = in.nextInt(), m = in.nextInt(), a = in.nextInt() - 1, b = in.nextInt() - 1;
    graph = in.nextGraph(n, m, false);
    boolean[][] used = new boolean[2][n];
    used[0][a] = used[0][b] = used[1][a] = used[1][b] = true;
    int[] q = new int[n];
    int ql, qr;
    for (int i = 0; i < 2; i++) {
        ql = qr = 0;
        q[qr++] = i == 0 ? a : b;
        while (ql < qr) {
            int v = q[ql++];
            for (int u : graph[v]) {
                if (!used[i][u]) {
                    used[i][u] = true;
                    q[qr++] = u;
                }
            }
        }
    }
    int[][] cnt = new int[2][2];
    for (int i = 0; i < n; i++) cnt[used[0][i] ? 1 : 0][used[1][i] ? 1 : 0]++;
    out.println((long) cnt[0][1] * cnt[1][0]);
}