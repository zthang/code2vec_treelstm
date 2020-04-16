static void solve() throws IOException {
    scan = new FastReader();
    pw = new PrintWriter(System.out, true);
    StringBuilder sb = new StringBuilder();
    n = ni();
    m = ni();
    adj = new ArrayList[n + 1];
    for (int i = 1; i <= n; ++i) {
        adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; ++i) {
        int u = ni(), v = ni();
        adj[u].add(v);
        adj[v].add(u);
    }
    lev = new int[n + 1];
    par = new int[n + 1];
    Arrays.fill(lev, -1);
    dfs(1, 0);
    if (max_cycle_len >= (int) ceil(sqrt(n))) {
        pl(2);
        pl(max_cycle_len);
        int curr = from;
        while (true) {
            p(curr);
            if (curr == to) {
                break;
            }
            curr = par[curr];
        }
    } else {
        pl(1);
        TreeSet<Integer> set = MIS();
        if (set.size() < ceil(sqrt(n))) {
            System.exit(1);
        } else {
            for (int i = 0; i < ceil(sqrt(n)); i++) {
                p(set.pollFirst());
            }
            pl();
        }
    }
    pw.close();
}