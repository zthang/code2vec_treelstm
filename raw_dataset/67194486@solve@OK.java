public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int t = in.scanInt();
    while (t-- > 0) {
        int n = in.scanInt() * 2;
        size = new int[n + 1];
        int[][] edges = new int[n - 1][3];
        int[] from = new int[n - 1];
        int[] to = new int[n - 1];
        int[] val = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            edges[i] = new int[] { in.scanInt(), in.scanInt(), in.scanInt() };
            from[i] = edges[i][0];
            to[i] = edges[i][1];
            val[i] = edges[i][2];
        }
        g = CodeX.packGraph(from, to, n);
        dfs(1, -1);
        long min = 0;
        long max = 0;
        for (int i = 0; i < n - 1; i++) {
            int m = Math.min(size[edges[i][0]], size[edges[i][1]]);
            max += (1l * edges[i][2] * Math.min(m, n - m));
            min += 1l * edges[i][2] * (m % 2);
        }
        out.println(min + " " + max);
    }
}