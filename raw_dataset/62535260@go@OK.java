void go() {
    int n = ni();
    int[] from = new int[n - 1];
    int[] to = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
        from[i] = ni() - 1;
        to[i] = ni() - 1;
    }
    int[][] g = packU(n, from, to);
    int[][] pars = parents3(g, 0);
    int[] par = pars[0], ord = pars[1], dep = pars[2];
    int[] dp = new int[n];
    int[] chs = new int[n];
    int ans = 0;
    for (int i = n - 1; i >= 0; i--) {
        int cur = ord[i];
        int p = 0;
        for (int e : g[cur]) {
            if (par[cur] == e)
                continue;
            chs[p++] = dp[e];
        }
        Arrays.sort(chs, 0, p);
        if (p >= 2) {
            int can = chs[p - 1] + chs[p - 2] + g[cur].length - 1;
            ans = Math.max(ans, can);
        } else if (p == 1) {
            int can = chs[p - 1] + g[cur].length;
            ans = Math.max(ans, can);
        } else {
            int can = 1;
            ans = Math.max(ans, can);
        }
        dp[cur] = (p >= 1 ? chs[p - 1] + g[cur].length - 1 : 1);
    }
    out.println(ans);
}