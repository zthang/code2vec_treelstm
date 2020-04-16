void solve() {
    int n = scn.nextInt();
    int[] col = scn.nextIntArray(n);
    for (int i = 0; i < n; i++) {
        if (col[i] == 0) {
            col[i]--;
        }
    }
    int[] from = new int[n - 1], to = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
        from[i] = scn.nextInt() - 1;
        to[i] = scn.nextInt() - 1;
    }
    int[][] g = packU(n, from, to);
    int[] sub = new int[n];
    func(g, col, sub, 0, -1);
    int[] ans = new int[n];
    f(g, col, sub, ans, 0, -1, 0);
    for (int a : ans) {
        out.print(a + " ");
    }
    out.println();
}