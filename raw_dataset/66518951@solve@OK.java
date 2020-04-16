void solve() throws IOException {
    PrintWriter out = new PrintWriter(System.out);
    StringBuilder sb = new StringBuilder("");
    n = ni();
    m = ni();
    adj = new HashSet[n];
    for (int i = 0; i < n; i++) adj[i] = new HashSet<>();
    for (int i = 0; i < m; i++) {
        int u = ni() - 1, v = ni() - 1;
        adj[u].add(v);
        adj[v].add(u);
    }
    grp = new HashSet[n];
    for (int i = 0; i < n; i++) grp[i] = new HashSet<>();
    vis = new boolean[n];
    int id = 0;
    for (int i = 0; i < n; i++) {
        if (vis[i])
            continue;
        dfs(i, id);
        id++;
    }
    int[] gp = new int[n];
    // upto id
    int[] mngp = new int[n];
    // upto id
    int[] mxgp = new int[n];
    for (int i = 0; i < id; i++) {
        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        for (int j : grp[i]) {
            gp[j] = i;
            mn = Math.min(mn, j);
            mx = Math.max(mx, j);
        }
        mngp[i] = mn;
        mxgp[i] = mx;
    }
    int ans = 0;
    HashSet<Integer> proc = new HashSet<>();
    for (int i = 0; i < n; i++) {
        if (proc.contains(gp[i]))
            continue;
        int cur = gp[i];
        for (int j = i; j <= mxgp[cur]; j++) {
            if (grp[cur].contains(j))
                continue;
            ans++;
            int gpj = gp[j];
            for (int k : grp[gpj]) grp[cur].add(k);
            proc.add(gpj);
            mxgp[cur] = Math.max(mxgp[cur], mxgp[gpj]);
        }
        proc.add(cur);
    }
    System.out.println(ans);
}