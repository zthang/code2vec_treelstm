void solve() {
    // cycleがないならsをrootとして木の最重パス
    // cycleの中にいるならcycles + max(leg)
    // cycleの外にいるなら、cycleまでの経路もcyclesとしてカウント。legから移動
    int n = ni(), m = ni();
    int[] w = na(n);
    int[] from = new int[m];
    int[] to = new int[m];
    for (int i = 0; i < m; i++) {
        from[i] = ni() - 1;
        to[i] = ni() - 1;
    }
    int[][] g = packU(n, from, to);
    int S = ni() - 1;
    if (m == n - 1) {
        int[][] pars = parents3(g, S);
        int[] par = pars[0], ord = pars[1];
        long[] dp = new long[n];
        dp[S] = w[S];
        long ans = w[S];
        for (int i = 1; i < n; i++) {
            int cur = ord[i];
            dp[cur] = dp[par[cur]] + w[cur];
            ans = Math.max(ans, dp[cur]);
        }
        out.println(ans);
        return;
    }
    int[] clus = decomposeToBECC(g);
    int[][] cg = condense(g, clus);
    int u = cg.length;
    int[] cf = new int[u];
    for (int v : clus) cf[v]++;
    long[] cw = new long[u];
    for (int i = 0; i < n; i++) {
        cw[clus[i]] += w[i];
    }
    int root = -1;
    for (int i = 0; i < u; i++) {
        if (cf[i] > 1) {
            root = i;
        }
    }
    int[][] pars = parents3(cg, root);
    int[] par = pars[0], ord = pars[1];
    boolean[] inbound = new boolean[u];
    for (int i = u - 1; i >= 0; i--) {
        int cur = ord[i];
        if (cf[cur] > 1 || clus[S] == cur) {
            inbound[cur] = true;
        }
        if (i > 0)
            inbound[par[cur]] |= inbound[cur];
    }
    long winbound = 0;
    for (int i = 0; i < u; i++) {
        if (inbound[i]) {
            winbound += cw[i];
        }
    }
    long maxleg = 0;
    long[] legs = new long[u];
    for (int i = 1; i < u; i++) {
        int cur = ord[i];
        if (inbound[cur])
            continue;
        legs[cur] = legs[par[cur]] + cw[cur];
        maxleg = Math.max(maxleg, legs[cur]);
    }
    // tr(legs, winbound);
    out.println(winbound + maxleg);
}