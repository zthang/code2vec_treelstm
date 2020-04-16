void solve(int TC) throws Exception {
    int n = ni(), m = ni();
    long[] w = new long[n];
    for (int i = 0; i < n; i++) w[i] = nl();
    int[][] e = new int[m][];
    for (int i = 0; i < m; i++) e[i] = new int[] { ni() - 1, ni() - 1, i };
    int s = ni() - 1;
    int[][][] g = makeUS(n, e);
    boolean[] bridge = bridge(g, m);
    int[][] set = new int[2][n];
    for (int i = 0; i < n; i++) {
        set[0][i] = i;
        set[1][i] = 1;
    }
    for (int i = 0; i < m; i++) if (!bridge[i]) {
        int u = find(set, e[i][0]), v = find(set, e[i][1]);
        set[1][u] += set[1][v];
        set[0][v] = u;
    }
    int cnt = 0;
    for (int i = 0; i < n; i++) if (set[0][find(set, i)] == i)
        cnt++;
    boolean[] sp = new boolean[cnt];
    long[] wc = new long[cnt];
    int[] mp = new int[n];
    Arrays.fill(mp, -1);
    int ind = 0;
    for (int i = 0; i < n; i++) {
        if (set[0][i] != i)
            continue;
        mp[i] = ind++;
        if (set[1][i] > 1)
            sp[mp[i]] = true;
    }
    for (int i = 0; i < n; i++) wc[mp[find(set, i)]] += w[i];
    int[][] ee = new int[m][];
    int c = 0;
    for (int i = 0; i < m; i++) if (bridge[i])
        ee[c++] = new int[] { mp[find(set, e[i][0])], mp[find(set, e[i][1])] };
    ee = Arrays.copyOfRange(ee, 0, c);
    int root = mp[find(set, s)];
    int[][] gg = makeU(cnt, ee);
    long[] ans = dfs(gg, sp, wc, root, -1);
    pn(ans[0]);
}