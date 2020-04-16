static void solve() throws IOException {
    // initIo(true);
    initIo(false);
    StringBuilder sb = new StringBuilder();
    int n = ni(), q = ni();
    Edge[] events = new Edge[n - 1 + q];
    for (int i = 0; i < n - 1; ++i) {
        int u = ni(), v = ni(), w = ni();
        events[i] = new Edge(u, v, w, 0);
    }
    for (int i = 0; i < q; ++i) {
        events[n - 1 + i] = new Edge(i, i, ni(), 1);
    }
    Arrays.sort(events);
    // pa("events", events);
    init(n);
    long[] ans = new long[q];
    for (Edge e : events) {
        if (e.type == 0) {
            un(e.x, e.y);
        } else {
            ans[e.x] = curr;
        }
    }
    for (long e : ans) {
        sb.append(e);
        sb.append(" ");
    }
    pl(sb);
    pw.flush();
    pw.close();
}