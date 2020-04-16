void solve() {
    int n = ni();
    int[] a = na(n);
    int[] d0 = go(a, 0);
    int[] d1 = go(a, 1);
    for (int i = 0; i < n; i++) {
        if (a[i] % 2 == 0) {
            out.print((d0[i] > 999999 ? -1 : d0[i]) + " ");
        } else {
            out.print((d1[i] > 999999 ? -1 : d1[i]) + " ");
        }
    }
    out.println();
}