static void solve() throws IOException {
    // initIo(true);
    initIo(false);
    StringBuilder sb = new StringBuilder();
    // pl((char)('a'+25));
    int n = ni(), k = ni();
    int[] a = new int[n];
    int[] pos = new int[n + 1];
    for (int i = 0; i < n; ++i) {
        a[i] = ni();
        pos[a[i]] = i;
    }
    int[] b = new int[n];
    int[] p = new int[n];
    for (int i = 0; i < n; ++i) {
        b[i] = ni();
        p[i] = pos[b[i]];
    }
    int[] pref_max = new int[n];
    for (int i = 0; i < n; ++i) {
        pref_max[i] = p[i];
        if (i > 0) {
            pref_max[i] = max(pref_max[i], pref_max[i - 1]);
        }
    }
    int[] suff_min = new int[n];
    for (int i = n - 1; i >= 0; --i) {
        suff_min[i] = p[i];
        if (i + 1 < n) {
            suff_min[i] = min(suff_min[i], suff_min[i + 1]);
        }
    }
    int[] at = new int[n];
    at[0] = 0;
    for (int i = 1; i < n; ++i) {
        if (suff_min[i] >= pref_max[i - 1]) {
            at[i] = at[i - 1] + 1;
            at[i] = min(at[i], 25);
        } else {
            at[i] = at[i - 1];
        }
    }
    if (at[n - 1] >= k - 1) {
        pl("YES");
        char[] ans = new char[n];
        for (int i = 0; i < n; ++i) {
            ans[b[i] - 1] = (char) ('a' + at[i]);
        }
        for (int i = 0; i < n; ++i) {
            pw.print(ans[i]);
        }
        pl();
    } else {
        pl("NO");
    }
    pw.flush();
    pw.close();
}