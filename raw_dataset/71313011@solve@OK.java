static void solve() {
    n = in.nextInt();
    m = in.nextInt();
    k = in.nextInt();
    a = new Integer[k];
    for (int i = 0; i < k; i++) {
        a[i] = in.nextInt() - 1;
    }
    g = new ArrayList[n];
    Arrays.setAll(g, gi -> new ArrayList<>());
    for (int i = 0; i < m; i++) {
        int v = in.nextInt() - 1;
        int u = in.nextInt() - 1;
        g[v].add(u);
        g[u].add(v);
    }
    d = new int[n][2];
    for (int i = 0; i < n; i++) {
        d[i][0] = d[i][1] = -1;
    }
    LinkedList<Integer> q = new LinkedList<>();
    q.addLast(0);
    d[0][0] = 0;
    while (!q.isEmpty()) {
        int v = q.pollFirst();
        for (int u : g[v]) {
            if (d[u][0] == -1) {
                d[u][0] = d[v][0] + 1;
                q.addLast(u);
            }
        }
    }
    q.addLast(n - 1);
    d[n - 1][1] = 0;
    while (!q.isEmpty()) {
        int v = q.pollFirst();
        for (int u : g[v]) {
            if (d[u][1] == -1) {
                d[u][1] = d[v][1] + 1;
                q.addLast(u);
            }
        }
    }
    // for (int i = 0; i < n; i++) {
    // out.println(d[i][0] + " " + d[i][1]);
    // }
    Arrays.sort(a, (o1, o2) -> Integer.compare(d[o1][0], d[o2][0]));
    int[] max = new int[k];
    max[k - 1] = d[a[k - 1]][1];
    for (int i = k - 2; i >= 0; i--) {
        max[i] = Math.max(max[i + 1], d[a[i]][1]);
    // out.println(d[a[i]][1]);
    }
    int ans = 0;
    for (int i = 0; i < k - 1; i++) {
        ans = Math.max(ans, d[a[i]][0] + 1 + max[i + 1]);
    }
    // out.println(ans);
    Arrays.sort(a, (o1, o2) -> Integer.compare(d[o1][1], d[o2][1]));
    max = new int[k];
    max[k - 1] = d[a[k - 1]][0];
    for (int i = k - 2; i >= 0; i--) {
        max[i] = Math.max(max[i + 1], d[a[i]][0]);
    }
    for (int i = 0; i < k - 1; i++) {
        // out.println(d[a[i]][1]);
        ans = Math.max(ans, d[a[i]][1] + 1 + max[i + 1]);
    }
    ans = Math.min(ans, d[n - 1][0]);
    out.println(ans);
}