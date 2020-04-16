void solve(int TC) throws Exception {
    int n = ni(), k = ni();
    String s = n();
    int[][] li = new int[n][2];
    int[] cnt = new int[n];
    for (int i = 0; i < k; i++) {
        int c = ni();
        for (int j = 0; j < c; j++) {
            int x = ni() - 1;
            li[x][cnt[x]++] = i;
        }
    }
    int[] set = new int[k], dep = new int[k];
    long[][] d = new long[k][];
    for (int i = 0; i < k; i++) {
        set[i] = i;
        dep[i] = 0;
        d[i] = new long[] { 1, 0 };
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
        if (cnt[i] == 0) {
            hold(s.charAt(i) == '1');
        } else if (cnt[i] == 1) {
            int u = li[i][0], w = s.charAt(i) == '0' ? 1 : 0;
            int ru = find(set, dep, u);
            w ^= dep[u];
            ans -= Math.min(d[ru][0], d[ru][1]);
            d[ru][w] = (long) 1e13;
            ans += Math.min(d[ru][0], d[ru][1]);
        } else {
            int u = li[i][0], v = li[i][1], w = s.charAt(i) == '1' ? 0 : 1;
            int ru = find(set, dep, u), rv = find(set, dep, v);
            if (ru == rv)
                hold((dep[u] ^ dep[v]) == w);
            else {
                w ^= dep[u] ^ dep[v];
                ans -= Math.min(d[ru][0], d[ru][1]);
                ans -= Math.min(d[rv][0], d[rv][1]);
                d[ru][0 ^ w] += d[rv][0];
                d[ru][1 ^ w] += d[rv][1];
                dep[rv] = w;
                set[rv] = ru;
                ans += Math.min(d[ru][0], d[ru][1]);
            }
        }
        pn(ans);
    }
}