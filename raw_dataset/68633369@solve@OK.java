public static void solve() {
    int t = s.nextInt();
    while (t-- > 0) {
        int n = s.nextInt();
        int m = s.nextInt();
        int a = s.nextInt() - 1;
        int b = s.nextInt() - 1;
        adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int u = s.nextInt() - 1;
            int v = s.nextInt() - 1;
            adj[u].add(v);
            adj[v].add(u);
        }
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) make_set(i);
        // considering a is not available
        for (int i = 0; i < n; i++) {
            if (i != a) {
                for (Integer x : adj[i]) {
                    if (x != a) {
                        Union_set(i, x);
                    }
                }
            }
        }
        int v = find_set(b);
        int sizeb = size[v];
        long ans = n - sizeb - 1;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) make_set(i);
        // Considering b is not available
        for (int i = 0; i < n; i++) {
            if (i != b) {
                for (Integer x : adj[i]) {
                    if (x != b) {
                        Union_set(i, x);
                    }
                }
            }
        }
        ans = ans * (n - size[find_set(a)] - 1);
        out.println(ans);
    }
}