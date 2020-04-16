static void solve() {
    int n = in.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    for (int i = 0; i < n; i++) {
        x[i] = in.nextInt();
        y[i] = in.nextInt();
    }
    int[] c = new int[n];
    for (int i = 0; i < n; i++) {
        c[i] = in.nextInt();
    }
    int[] k = new int[n];
    for (int i = 0; i < n; i++) {
        k[i] = in.nextInt();
    }
    long ans = 0;
    ArrayList<Integer> vs = new ArrayList<>();
    ArrayList<Pair> es = new ArrayList<>();
    boolean[] used = new boolean[n];
    long[] d = new long[n];
    int[] from = new int[n];
    for (int i = 0; i < n; i++) {
        d[i] = c[i];
        from[i] = -1;
    }
    for (int i = 0; i < n; i++) {
        int v = -1;
        for (int u = 0; u < n; u++) {
            if (!used[u] && (v == -1 || d[u] < d[v]))
                v = u;
        }
        ans += d[v];
        if (from[v] == -1)
            vs.add(v + 1);
        else
            es.add(new Pair(from[v] + 1, v + 1));
        used[v] = true;
        for (int u = 0; u < n; u++) {
            if (used[u])
                continue;
            long dd = (long) (k[v] + k[u]) * (Math.abs(x[v] - x[u]) + Math.abs(y[v] - y[u]));
            if (dd < d[u]) {
                d[u] = dd;
                from[u] = v;
            }
        }
    }
    out.println(ans);
    out.println(vs.size());
    for (int v : vs) {
        out.print(v + " ");
    }
    out.println();
    out.println(es.size());
    for (Pair e : es) {
        out.println(e.v + " " + e.u);
    }
}