static void solve() throws IOException {
    // initIo(true);
    initIo(false);
    StringBuilder sb = new StringBuilder();
    int n = ni(), k = ni();
    char[] c = ne().toCharArray();
    int[][] which = new int[n + 1][2];
    for (int i = 0; i <= n; ++i) {
        which[i][0] = which[i][1] = -1;
    }
    for (int i = 0; i < k; ++i) {
        int cnt = ni();
        for (int j = 0; j < cnt; ++j) {
            int x = ni();
            if (which[x][0] == -1) {
                which[x][0] = i;
            } else {
                which[x][1] = i;
            }
        }
    }
    adj = new ArrayList[k];
    for (int i = 0; i < k; ++i) {
        adj[i] = new ArrayList<>();
    }
    for (int i = 1; i <= n; ++i) {
        if (which[i][0] != -1 && which[i][1] != -1) {
            int u = which[i][0], v = which[i][1];
            // pl(u+" "+v + " " + c[i-1]);
            if (c[i - 1] == '1') {
                adj[u].add(new Pair(v, 0));
                adj[v].add(new Pair(u, 0));
            } else {
                adj[u].add(new Pair(v, 1));
                adj[v].add(new Pair(u, 1));
            }
        }
    }
    color = new int[k];
    Arrays.fill(color, -1);
    for (int i = 0; i < k; ++i) {
        if (color[i] == -1) {
            color[i] = 0;
            dfs(i);
        }
    }
    // pa("color", color);
    init((k - 1));
    for (int i = 1; i <= n; ++i) {
        // pl("i : "+i+" "+which[i][0]+" "+which[i][1]);
        if (which[i][0] != -1 && which[i][1] != -1) {
            un(which[i][0], which[i][1]);
        } else if (which[i][0] != -1) {
            int root = gr(which[i][0]);
            if (c[i - 1] == '0') {
                ans -= (forced[root] == -1 ? min(red_count[root], blue_count[root]) : forced[root] == 0 ? red_count[root] : blue_count[root]);
                forced[root] = color[which[i][0]];
                ans += (forced[root] == -1 ? min(red_count[root], blue_count[root]) : forced[root] == 0 ? red_count[root] : blue_count[root]);
            } else {
                ans -= (forced[root] == -1 ? min(red_count[root], blue_count[root]) : forced[root] == 0 ? red_count[root] : blue_count[root]);
                forced[root] = 1 - color[which[i][0]];
                ans += (forced[root] == -1 ? min(red_count[root], blue_count[root]) : forced[root] == 0 ? red_count[root] : blue_count[root]);
            }
        }
        pl(ans);
    }
    pw.flush();
    pw.close();
}