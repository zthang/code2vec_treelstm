static void solve() throws IOException {
    // initIo(true);
    initIo(false);
    StringBuilder sb = new StringBuilder();
    int n = ni();
    init(n);
    int[] prev = new int[26];
    Arrays.fill(prev, -1);
    for (int i = 1; i <= n; ++i) {
        String s = ne();
        int len = s.length();
        for (int j = 0; j < len; ++j) {
            int p = s.charAt(j) - 'a';
            if (prev[p] != -1) {
                un(i, prev[p]);
            }
            prev[p] = i;
        }
    }
    int ans = 0;
    for (int i = 1; i <= n; ++i) {
        if (gr(i) == i) {
            ++ans;
        }
    }
    pl(ans);
    pw.flush();
    pw.close();
}