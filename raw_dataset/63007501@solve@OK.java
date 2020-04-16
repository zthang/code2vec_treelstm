void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    int[] us = new int[m];
    int[] vs = new int[m];
    int[] fc = new int[n];
    int[] tc = new int[n];
    used = new boolean[n];
    order = new int[n];
    for (int i = 0; i < m; i++) {
        int u = nextInt() - 1;
        us[i] = u;
        int v = nextInt() - 1;
        vs[i] = v;
        fc[u]++;
        tc[v]++;
    }
    es = new int[n][];
    er = new int[n][];
    for (int i = 0; i < n; i++) {
        es[i] = new int[fc[i]];
        fc[i] = 0;
        er[i] = new int[tc[i]];
        tc[i] = 0;
    }
    for (int i = 0; i < m; i++) {
        int u = us[i];
        int v = vs[i];
        es[u][fc[u]++] = v;
        er[v][tc[v]++] = u;
    }
    time = 0;
    for (int i = 0; i < n; i++) {
        if (!used[i]) {
            dfs1(i);
        }
    }
    Arrays.fill(used, false);
    ans = new TreeSet<>();
    dfs2(order[n - 1]);
    if (ans.size() == n) {
        out.println("No");
        return;
    }
    out.println("Yes");
    out.println(ans.size() + " " + (n - ans.size()));
    for (int x : ans) {
        out.print((x + 1) + " ");
    }
    out.println();
    for (int x = 0; x < n; x++) {
        if (!ans.contains(x)) {
            out.print((x + 1) + " ");
        }
    }
    out.println();
}