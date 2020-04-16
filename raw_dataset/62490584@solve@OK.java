void solve() throws IOException {
    n = ni();
    B = new int[n + 1][4];
    for (int x = 1; x < 4; x++) {
        for (int y = 1; y <= n; y++) B[y][x] = ni();
    }
    A = new ArrayList[n + 1];
    for (int x = 1; x <= n; x++) A[x] = new ArrayList();
    boolean f = true;
    int s = 0;
    for (int x = 1; x < n; x++) {
        int u = ni(), v = ni();
        A[v].add(u);
        if (A[v].size() > 2)
            f = false;
        A[u].add(v);
        if (A[u].size() > 2)
            f = false;
    }
    if (!f) {
        System.out.println("-1");
        return;
    }
    for (int x = 1; x <= n; x++) {
        if (A[x].size() == 1) {
            s = x;
            break;
        }
    }
    long ans = Long.MAX_VALUE;
    long newans;
    C = new int[4];
    E = new int[4];
    for (int x = 1; x < 4; x++) {
        for (int y = 1; y < 4; y++) {
            if (y == x)
                continue;
            for (int z = 1; z < 4; z++) {
                if (z == x || z == y)
                    continue;
                C[1] = x;
                C[2] = y;
                C[3] = z;
                newans = dfs(s, 0, 1);
                if (newans < ans) {
                    ans = newans;
                    E[1] = C[1];
                    E[2] = C[2];
                    E[3] = C[3];
                }
            }
        }
    }
    System.out.println(ans);
    D = new int[n + 1];
    dfs2(s, 0, 1);
    for (int x = 1; x <= n; x++) out.print(D[x] + " ");
    out.println();
    out.flush();
}