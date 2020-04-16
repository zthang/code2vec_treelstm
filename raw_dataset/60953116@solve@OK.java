public void solve(int testNumber, FastScanner in, PrintWriter out) {
    n = in.nextInt();
    int m = in.nextInt();
    w = new int[n];
    for (int i = 0; i < n; i++) {
        w[i] = in.nextInt();
    }
    adj = new List[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        adj[a].add(b);
        adj[b].add(a);
    }
    root = in.nextInt() - 1;
    parent = new int[n];
    Arrays.fill(parent, -1);
    inCore = new boolean[n];
    Arrays.fill(inCore, true);
    deg = new int[n];
    for (int i = 0; i < n; i++) {
        deg[i] = adj[i].size();
    }
    for (int i = 0; i < n; i++) {
        if (adj[i].size() == 1) {
            dfs(i, -1);
        }
    }
    int coreSize = 0;
    for (int i = 0; i < n; i++) {
        if (inCore[i]) {
            ++coreSize;
        }
    }
    if (coreSize == 0) {
        out.println(heaviestPath(root, -1));
        return;
    }
    long ans = 0;
    long rootSubtree = 0;
    if (!inCore[root]) {
        rootSubtree = heaviestPath(root, parent[root]);
        for (int i = root; !inCore[i]; i = parent[i]) {
            ans += w[i];
            w[i] = 0;
        }
    }
    long max = 0;
    for (int i = 0; i < n; i++) {
        if (!inCore[i]) {
            continue;
        }
        ans += w[i];
        for (int j : adj[i]) {
            if (!inCore[j]) {
                max = Math.max(max, heaviestPath(j, i));
            }
        }
    }
    ans += max;
    ans = Math.max(ans, rootSubtree);
    out.println(ans);
}