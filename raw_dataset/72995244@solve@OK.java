void solve() {
    int n = ni();
    int m = ni();
    dp = new int[n + 1];
    Arrays.fill(dp, 10000000);
    ArrayList<Integer>[] g = new ArrayList[n + 1];
    HashSet<Integer>[] h = new HashSet[n + 1];
    for (int i = 0; i < n + 1; i++) g[i] = new ArrayList<>();
    for (int i = 0; i < n + 1; i++) h[i] = new HashSet<>();
    for (int i = 0; i < m; i++) {
        int u = ni();
        int v = ni();
        g[v].add(u);
    }
    int k = ni();
    int[] b = na(k);
    Queue<Integer> q = new LinkedList<>();
    Queue<Integer> dist = new LinkedList<>();
    q.add(b[k - 1]);
    dist.add(0);
    while (q.size() != 0) {
        int node = q.poll();
        int d = dist.poll();
        for (int j : g[node]) {
            if (dp[j] == 10000000) {
                dp[j] = d + 1;
                h[j].add(node);
                q.add(j);
                dist.add(dp[j]);
            } else if (dp[j] == d + 1) {
                h[j].add(node);
            }
        }
    }
    int min = 0;
    int max = 0;
    for (int i = 0; i < k - 1; i++) {
        // out.println(h[b[i]]);
        if (!h[b[i]].contains(b[i + 1])) {
            min++;
            max++;
        } else {
            if (h[b[i]].size() > 1)
                max++;
        }
    }
    out.println(min + " " + max);
}