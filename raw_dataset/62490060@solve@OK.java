public void solve(int testNumber, InputReader in, PrintWriter out) {
    this.out = out;
    this.in = in;
    int n = ni();
    long[][] col = new long[3][n];
    int i = 0, j = 0, k = 0;
    int[] deg = new int[n];
    for (i = 0; i < n; i++) {
        col[0][i] = nl();
        tree[i] = new ArrayList<>();
    }
    for (i = 0; i < n; i++) col[1][i] = nl();
    for (i = 0; i < n; i++) col[2][i] = nl();
    for (i = 0; i < n - 1; i++) {
        int u = ni() - 1;
        int v = ni() - 1;
        tree[u].add(v);
        tree[v].add(u);
        deg[u]++;
        deg[v]++;
    }
    boolean ok = true;
    int root = -1;
    for (i = 0; i < n; i++) {
        if (deg[i] > 2)
            ok = false;
        if (deg[i] == 1)
            root = i;
    }
    if (!ok) {
        pn(-1);
        return;
    }
    dfs(root, -1);
    long[][][] dp = new long[n][3][3];
    for (i = 0; i < n; i++) {
        for (j = 0; j < 3; j++) Arrays.fill(dp[i][j], INF);
    }
    Tuple[][][] nxt = new Tuple[n][3][3];
    for (i = 0; i < 3; i++) {
        for (j = 0; j < 3; j++) {
            dp[0][i][j] = col[j][root];
            nxt[0][i][j] = new Tuple(-1, -1);
        }
    }
    for (i = 0; i < 3; i++) {
        for (j = 0; j < 3; j++) {
            if (i == j)
                dp[1][i][j] = INF;
            else {
                if (dp[0][i][i] + col[j][path.get(1)] < dp[1][i][j]) {
                    nxt[1][i][j] = new Tuple(i, i);
                    dp[1][i][j] = dp[0][i][i] + col[j][path.get(1)];
                }
            }
        }
    }
    for (i = 2; i < n; i++) {
        int which = path.get(i);
        for (j = 0; j < 3; j++) {
            for (k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    if (j != k && k != l && j != l) {
                        if (dp[i - 1][j][k] + col[l][which] < dp[i][k][l]) {
                            nxt[i][k][l] = new Tuple(j, k);
                            dp[i][k][l] = dp[i - 1][j][k] + col[l][which];
                        }
                    }
                }
            }
        }
    }
    Tuple min_ind = new Tuple(-1, -1);
    long min = INF;
    for (i = 0; i < 3; i++) {
        for (j = 0; j < 3; j++) {
            if (dp[n - 1][i][j] < min) {
                min = dp[n - 1][i][j];
                min_ind = new Tuple(i, j);
            }
        }
    }
    pn(min);
    int[] ans = new int[n];
    ans[path.get(n - 1)] = min_ind.y;
    int p = n - 1;
    while (true) {
        min_ind = nxt[p][min_ind.x][min_ind.y];
        if (min_ind.x == -1)
            break;
        p--;
        ans[path.get(p)] = min_ind.y;
    }
    for (i = 0; i < n; i++) p(ans[i] + 1 + " ");
}