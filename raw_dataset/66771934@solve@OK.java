void solve() {
    int n = ni();
    int[] a = na(n);
    int[] odd = go(a, false);
    int[] even = go(a, true);
    for (int i = 0; i < n; i++) {
        if (a[i] % 2 == 0) {
            out.print((even[i] == 99999999 ? -1 : even[i]) + " ");
        } else {
            out.print((odd[i] == 99999999 ? -1 : odd[i]) + " ");
        }
    }
    out.println();
}