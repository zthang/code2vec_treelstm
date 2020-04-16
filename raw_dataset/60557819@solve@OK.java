public void solve(int testNumber, FastScanner in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    List<Integer>[] adj = new List[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        adj[a].add(b);
        adj[b].add(a);
    }
    int ans = 0;
    boolean[] was = new boolean[n];
    int[] q = new int[n];
    for (int s = 0; s < n; s++) {
        if (was[s]) {
            continue;
        }
        int qt = 0;
        int qh = 1;
        q[0] = s;
        was[s] = true;
        while (qt < qh) {
            int v = q[qt++];
            for (int u : adj[v]) {
                if (!was[u]) {
                    q[qh++] = u;
                    was[u] = true;
                }
            }
        }
        ans += qh - 1;
    }
    out.println(m - ans);
}