void solve() {
    int n = ni(), m = ni();
    DynamicConnectivity10ForCheck dc = new DynamicConnectivity10ForCheck(n);
    int last = 0;
    Set<Long> es = new HashSet<>();
    for (int i = 0; i < m; i++) {
        int t = ni();
        if (t == 1) {
            int x = (ni() + last) % n, y = (ni() + last) % n;
            if (x > y) {
                int d = x;
                x = y;
                y = d;
            }
            long code = (long) x << 32 | y;
            if (es.contains(code)) {
                es.remove(code);
                dc.delete(x, y);
            } else {
                dc.union(x, y);
                es.add(code);
            }
        } else {
            int x = (ni() + last) % n, y = (ni() + last) % n;
            last = dc.areConnected(x, y) ? 1 : 0;
            out.print(last);
        }
    }
}