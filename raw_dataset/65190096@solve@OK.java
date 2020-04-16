static void solve() throws IOException {
    // initIo(true);
    initIo(false);
    StringBuilder sb = new StringBuilder();
    int n = ni(), m = ni();
    init(n);
    for (int i = 0; i < m; ++i) {
        un(ni(), ni());
    }
    int ans = 0;
    for (int i = 1; i <= n; ++i) {
        int org = i;
        int max = max_in_cc[gr(i)];
        while (i < max) {
            if (gr(i) != gr(org)) {
                ans++;
                un(i, org);
                max = max(max, max_in_cc[gr(org)]);
            }
            i++;
        }
    }
    pl(ans);
    pw.flush();
    pw.close();
}