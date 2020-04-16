public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    if (n <= 6) {
        out.println(m);
        return;
    }
    int[][] edges = new int[m][2];
    for (int i = 0; i < m; i++) {
        edges[i][0] = in.nextInt() - 1;
        edges[i][1] = in.nextInt() - 1;
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            HashSet<Integer>[] dif = new HashSet[n];
            for (int k = 0; k < n; k++) dif[k] = new HashSet<>();
            for (int k = 0; k < m; k++) {
                int u = (edges[k][0] == j) ? i : edges[k][0];
                int v = (edges[k][1] == j) ? i : edges[k][1];
                dif[u].add(v);
                dif[v].add(u);
            }
            int idk = 0;
            for (int k = 0; k < n; k++) idk += dif[k].size();
            ans = Math.max((idk + 1) / 2, ans);
        }
    }
    out.println(ans);
}