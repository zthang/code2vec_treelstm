void solve() {
    int n = ni(), m = ni();
    int[] from = new int[m];
    int[] to = new int[m];
    for (int i = 0; i < m; i++) {
        from[i] = ni() - 1;
        to[i] = ni() - 1;
    }
    int[][] g = packU(n, from, to);
    out.println(enumConnectedComponentFromComplementGraph(g).count() - 1);
}