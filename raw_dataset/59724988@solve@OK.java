void solve(int TC) throws Exception {
    int n = ni(), m = ni(), mx = (int) 2e5 + 2;
    int[][] e = new int[n - 1][];
    for (int i = 0; i < n - 1; i++) e[i] = new int[] { ni() - 1, ni() - 1, ni() };
    int[][] set = new int[n][];
    for (int i = 0; i < n; i++) set[i] = new int[] { i, 1 };
    Arrays.sort(e, (int[] i1, int[] i2) -> Integer.compare(i1[2], i2[2]));
    long[] pairs = new long[mx];
    for (int i = 0; i < n - 1; i++) {
        int u = find(set, e[i][0]), v = find(set, e[i][1]);
        pairs[e[i][2]] += set[u][1] * (long) (set[v][1]);
        set[v][0] = u;
        set[u][1] += set[v][1];
    }
    for (int i = 1; i < mx; i++) pairs[i] += pairs[i - 1];
    while (m-- > 0) p(pairs[ni()] + " ");
    pn("");
}