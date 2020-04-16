void solve() {
    n = ni();
    k = ni();
    char[] s = ns().toCharArray();
    ArrayList<Integer>[] g = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
    N = k + 1;
    for (int i = 1; i <= k; i++) {
        int c = ni();
        for (int j = 1; j <= c; j++) {
            int x = ni();
            g[x].add(i);
        }
    }
    F = new int[2 * N + 1];
    sz = new int[2 * N + 1];
    cost = new long[2 * N + 1];
    for (int i = 1; i <= 2 * N; i++) {
        F[i] = i;
        sz[i] = 1;
    }
    for (int i = 1; i < N; i++) {
        cost[i] = 1;
    }
    cost[2 * (k + 1)] = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
        if (g[i].size() == 1) {
            union(g[i].get(0), k + 1, s[i - 1] == '0');
        } else if (g[i].size() == 2) {
            union(g[i].get(0), g[i].get(1), s[i - 1] == '1');
        }
        pw.println(total);
    }
}