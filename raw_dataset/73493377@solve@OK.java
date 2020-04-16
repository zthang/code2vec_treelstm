public void solve(InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    ArrayList<Integer>[] a = new ArrayList[n + 1];
    ArrayList<Integer>[] b = new ArrayList[n + 1];
    int[] d = new int[n + 1];
    boolean[] chk = new boolean[n + 1];
    for (int i = 1; i <= n; i++) {
        d[i] = INF;
        chk[i] = false;
        a[i] = new ArrayList<>();
        b[i] = new ArrayList<>();
    }
    for (int i = 1; i <= m; i++) {
        int u = in.nextInt();
        int v = in.nextInt();
        a[u].add(v);
        b[v].add(u);
    }
    int k = in.nextInt();
    int[] p = new int[k];
    for (int i = 0; i < k; i++) {
        p[i] = in.nextInt();
    }
    ArrayDeque<Integer> Q = new ArrayDeque<>();
    d[p[k - 1]] = 0;
    Q.add(p[k - 1]);
    while (!Q.isEmpty()) {
        int u = Q.poll();
        for (int v : b[u]) {
            if (d[v] == INF) {
                d[v] = d[u] + 1;
                Q.add(v);
            }
        }
    }
    for (int u = 1; u <= n; u++) {
        int cnt = 0;
        for (int v : a[u]) {
            if (d[v] + 1 == d[u])
                cnt++;
        }
        if (cnt > 1)
            chk[u] = true;
    }
    int mn = 0, mx = 0;
    for (int i = 0; i < k - 1; i++) {
        if (d[p[i]] == d[p[i + 1]] + 1) {
            if (chk[p[i]])
                mx++;
        } else {
            mn++;
            mx++;
        }
    }
    out.print(mn + " " + mx);
}