public void solve(int testNumber, FastReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] g = new int[10][10];
    for (int i = 0; i < m; ++i) {
        int u = in.nextInt() - 1;
        int v = in.nextInt() - 1;
        g[u][v] += 1;
        g[v][u] += 1;
    }
    if (n < 7) {
        out.println(m);
        return;
    }
    long ans = 0;
    for (int firstNode = 0; firstNode < n; ++firstNode) {
        for (int secondNode = 0; secondNode < n; ++secondNode) {
            long temp = m;
            for (int tempNode = 0; tempNode < n; ++tempNode) {
                if (firstNode != tempNode && secondNode != tempNode && g[firstNode][tempNode] != 0 && g[secondNode][tempNode] != 0) {
                    --temp;
                }
            }
            ans = Math.max(ans, temp);
        }
    }
    out.println(ans);
}