private static void solve(int q, FastScanner in, PrintWriter out) {
    for (int qq = 0; qq < q; qq++) {
        int n = in.nextInt();
        int m = in.nextInt();
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            g[in.nextInt() - 1].add(in.nextInt() - 1);
        }
        int k = in.nextInt();
        p = new int[k];
        for (int i = 0; i < k; i++) {
            p[i] = in.nextInt() - 1;
        }
        sp = getSP(g, p[k - 1]);
        int[] res = solveHelper(0);
        out.println(res[0] + " " + res[1]);
    }
    out.close();
}