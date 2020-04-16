public int[][] gg(int n, int m) throws IOException {
    int[][] adja = new int[n + 1][];
    int[] from = new int[m];
    int[] to = new int[m];
    int[] count = new int[n + 1];
    for (int i = 0; i < m; i++) {
        from[i] = ni();
        to[i] = ni();
        count[from[i]]++;
        count[to[i]]++;
    }
    for (int i = 0; i <= n; i++) {
        adja[i] = new int[count[i]];
    }
    for (int i = 0; i < m; i++) {
        adja[from[i]][--count[from[i]]] = to[i];
        adja[to[i]][--count[to[i]]] = from[i];
    }
    return adja;
}