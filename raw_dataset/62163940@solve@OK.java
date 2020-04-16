void solve() {
    int t = scn.nextInt();
    for (int ii = 1; ii <= t; ii++) {
        int n = scn.nextInt();
        int[] from = new int[n - 1], to = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            from[i] = scn.nextInt() - 1;
            to[i] = scn.nextInt() - 1;
        }
        int[][] g = packU(n, from, to);
        int[] need = new int[n];
        func(g, need, 0, -1);
        int[] dp = new int[n];
        dfs(g, need, dp, 0, -1, 0);
        int ans = 0;
        for (int a : dp) {
            ans = Math.max(ans, a);
        }
        out.println(ans);
    }
}