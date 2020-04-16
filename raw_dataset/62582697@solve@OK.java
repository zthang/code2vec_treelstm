private static void solve() {
    int n = nextInt();
    c = new int[3][];
    c[0] = nextIntArrayOneBased(n);
    c[1] = nextIntArrayOneBased(n);
    c[2] = nextIntArrayOneBased(n);
    adj = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
    for (int e = 0; e < n - 1; e++) {
        int u = nextInt();
        int v = nextInt();
        adj[u].add(v);
        adj[v].add(u);
    }
    for (int i = 1; i <= n; i++) if (adj[i].size() > 2) {
        println(-1);
        return;
    }
    int start = 0;
    for (int i = 1; i <= n; i++) if (adj[i].size() == 1) {
        start = i;
        break;
    }
    int ptr = 1;
    perm = new int[n + 1];
    perm[ptr++] = start;
    perm[ptr++] = adj[start].get(0);
    for (; ptr <= n; ptr++) {
        perm[ptr] = adj[perm[ptr - 1]].get(0) == perm[ptr - 2] ? adj[perm[ptr - 1]].get(1) : adj[perm[ptr - 1]].get(0);
    }
    memo = new long[n + 1][4][4];
    for (long[][] a : memo) for (long[] b : a) Arrays.fill(b, -1);
    long ans = rec(n, 3, 3);
    int c1 = 3, c2 = 3;
    for (int i = 0; i < 3; i++) if (memo[perm[n]][3][3] == c[i][perm[n]] + memo[perm[n - 1]][i][3])
        c1 = i;
    int[] color = new int[n + 1];
    color[perm[n]] = c1;
    for (int i = n - 1; i >= 1; i--) {
        for (int j = 0; j < 3; j++) if (j != c1 && j != c2) {
            if (memo[perm[i]][c1][c2] == c[j][perm[i]] + memo[perm[i - 1]][j][c1]) {
                c2 = c1;
                c1 = j;
                color[perm[i]] = j;
                break;
            }
        }
    }
    println(ans);
    for (int i = 1; i <= n; i++) print((1 + color[i]) + " ");
}