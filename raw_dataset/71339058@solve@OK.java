static void solve() throws IOException {
    scan = new FastReader();
    pw = new PrintWriter(System.out, true);
    StringBuilder sb = new StringBuilder();
    n = ni();
    int m = ni(), k = ni();
    HashSet<Integer> special = new HashSet<>();
    for (int i = 0; i < k; ++i) {
        special.add(ni());
    }
    adj = new ArrayList[n + 1];
    for (int i = 1; i <= n; ++i) {
        adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; ++i) {
        int u = ni(), v = ni();
        adj[u].add(v);
        adj[v].add(u);
    }
    int[] sd1 = BFS(1);
    int[] sdn = BFS(n);
    // pa("sd1", sd1);
    // pa("sdn", sdn);
    ArrayList<Pair> list = new ArrayList<>();
    for (int i = 1; i <= n; ++i) {
        if (special.contains(i)) {
            list.add(new Pair(sd1[i], sdn[i]));
        }
    }
    // pa("list", list);
    // pl("getMax : "+getMax(list));
    int ans = getMax(list) + 1;
    pl(min(ans, sd1[n]));
    pw.flush();
    pw.close();
}