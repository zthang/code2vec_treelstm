void solve1() {
    int n = ni();
    int m = ni();
    int[][] e = new int[m][3];
    for (int i = 0; i < m; ++i) {
        int u = ni();
        int v = ni();
        int z = ni();
        e[i][0] = u;
        e[i][1] = v;
        e[i][2] = z;
    }
    Arrays.sort(e, (xx, yy) -> {
        return yy[2] - xx[2];
    });
    init(n + 1);
    gg = new int[n + 1][n + 1];
    go = new ArrayList[n + 1];
    for (int i = 0; i <= n; ++i) {
        go[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; ++i) {
        int p1 = e[i][0];
        int p2 = e[i][1];
        if (root(p1) != root(p2)) {
            combine(p1, p2);
            gg[p1][p2] = e[i][2];
            gg[p2][p1] = e[i][2];
            go[p1].add(p2);
            go[p2].add(p1);
        }
    }
    boolean[] vis = new boolean[n + 1];
    par = new int[n + 1][21];
    w = new int[n + 1][21];
    for (int j = 0; j < 21; ++j) {
        for (int i = 0; i <= n; ++i) {
            w[i][j] = 100000000;
        }
    }
    for (int i = 0; i <= n; ++i) {
        if (!vis[i]) {
            dfs(i, -1);
        }
    }
    for (int j = 1; j < 20; ++j) {
        for (int i = 1; i <= n; ++i) {
            w[i][j] = Math.min(w[i][j - 1], w[par[i][j - 1]][j - 1]);
            par[i][j] = par[par[i][j - 1]][j - 1];
        }
    }
    int q = ni();
    for (int i = 0; i < q; ++i) {
        int xx = ni();
        int yy = ni();
        if (root(xx) != root(yy)) {
            println(-1);
            continue;
        }
        int res = Integer.MAX_VALUE;
        for (int p = 20; p >= 0; --p) {
            if (par[xx][p] != par[yy][p]) {
                res = Math.min(res, w[xx][p]);
                res = Math.min(res, w[yy][p]);
                xx = par[xx][p];
                yy = par[yy][p];
            }
        }
        res = Math.min(res, w[xx][0]);
        res = Math.min(res, w[yy][0]);
        println(res);
    }
}