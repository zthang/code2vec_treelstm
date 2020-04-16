void solve() {
    int t = ni();
    for (int i = 0; i < t; ++i) {
        mp.clear();
        sz = 0;
        int n = ni();
        int[][] p = new int[2 * n][2];
        int x = 0;
        for (int j = 0; j < n; ++j) {
            int l = ni();
            int r = ni();
            p[x][0] = l;
            p[x][1] = j;
            x++;
            p[x][0] = r + 1;
            p[x][1] = ~j;
            x++;
        }
        Arrays.sort(p, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        int c = 0;
        int[] add = new int[n];
        for (int j = 0; j < 2 * n; ++j) {
            if (p[j][1] < 0) {
                remove(~p[j][1]);
            } else {
                insert(p[j][1]);
            }
            if (sz == 0) {
                c++;
            }
            if (j + 1 == 2 * n)
                continue;
            if (sz == 1 && p[j][1] < 0 && p[j + 1][1] >= 0) {
                add[front()]++;
            }
            if (sz == 1 && p[j][1] >= 0 && p[j + 1][1] < 0) {
                add[front()]--;
            }
        }
        int m = -n;
        for (int j = 0; j < n; ++j) {
            m = Math.max(m, c + add[j]);
        }
        println(m);
    }
}