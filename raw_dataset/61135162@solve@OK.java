static void solve() {
    int n = ir.nextInt();
    int m = ir.nextInt();
    int[][] a = new int[m][];
    for (int i = 0; i < m; i++) {
        a[i] = ir.nextIntArray(2);
        a[i][0]--;
        a[i][1]--;
    }
    int[] p = new int[n];
    int ma = 0;
    for (int i = 0; i < Math.pow(6, n); i++) {
        int x = i;
        for (int j = 0; j < n; j++) {
            p[j] = (x % 6) + 1;
            x /= 6;
        }
        HashSet<Long> st = new HashSet<>();
        for (int j = 0; j < m; j++) {
            int s = p[a[j][0]];
            int t = p[a[j][1]];
            if (s > t) {
                int tmp = s;
                s = t;
                t = tmp;
            }
            st.add((long) s << 30L | (long) t);
        }
        ma = Math.max(ma, st.size());
    }
    out.println(ma);
}