static void solve() {
    int n = in.nextInt();
    int k = in.nextInt();
    char[] s = in.next().toCharArray();
    int[][] a = new int[n][2];
    for (int i = 0; i < n; i++) {
        a[i][0] = a[i][1] = -1;
    }
    for (int i = 0; i < k; i++) {
        int m = in.nextInt();
        for (int j = 0; j < m; j++) {
            int x = in.nextInt() - 1;
            if (a[x][0] == -1) {
                a[x][0] = i;
            } else {
                a[x][1] = i;
            }
        }
    }
    int ans = 0;
    DSU dsu = new DSU(k);
    for (int i = 0; i < n; i++) {
        int flag = (s[i] - '0') ^ 1;
        if (a[i][1] != -1) {
            int v = a[i][0];
            int u = a[i][1];
            DSU.Pair pa1 = dsu.find(v);
            DSU.Pair pa2 = dsu.find(u);
            if (pa1.v != pa2.v) {
                ans -= dsu.s[pa1.v].get();
                ans -= dsu.s[pa2.v].get();
                if (rand.nextInt() % 2 == 1) {
                    DSU.Pair temp = pa1;
                    pa1 = pa2;
                    pa2 = temp;
                }
                dsu.s[pa2.v].p = pa1.v;
                flag ^= pa1.flag ^ pa2.flag;
                dsu.s[pa2.v].flag = flag;
                dsu.s[pa1.v].set(dsu.s[pa2.v].cnt[flag], dsu.s[pa2.v].cnt[flag ^ 1]);
                ans += dsu.s[pa1.v].get();
            }
        } else if (a[i][0] != -1) {
            int v = a[i][0];
            DSU.Pair pa = dsu.find(v);
            ans -= dsu.s[pa.v].get();
            flag ^= pa.flag;
            dsu.s[pa.v].cnt[flag ^ 1] = INF;
            ans += dsu.s[pa.v].get();
        }
        out.println(ans);
    }
}