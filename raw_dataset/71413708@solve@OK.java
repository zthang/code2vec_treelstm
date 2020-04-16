private static void solve(int q, FastScanner in, PrintWriter out) {
    for (int qq = 0; qq < q; qq++) {
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        int[] specialFields = new int[k];
        for (int i = 0; i < k; i++) {
            specialFields[i] = in.nextInt() - 1;
        }
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
        }
        fromSourceSp = new int[n];
        toDestSp = new int[n];
        bfs(fromSourceSp, 0);
        bfs(toDestSp, n - 1);
        int[][] sfFromSourceSp = new int[k][2];
        for (int i = 0; i < k; i++) {
            sfFromSourceSp[i][0] = fromSourceSp[specialFields[i]];
            sfFromSourceSp[i][1] = specialFields[i];
        }
        Arrays.sort(sfFromSourceSp, Comparator.comparingInt(a -> a[0]));
        int best = 0;
        for (int i = 1; i < k; i++) {
            best = Math.max(best, sfFromSourceSp[i - 1][0] + toDestSp[sfFromSourceSp[i][1]]);
        }
        out.println(Math.min(best + 1, fromSourceSp[n - 1]));
    }
    out.close();
}