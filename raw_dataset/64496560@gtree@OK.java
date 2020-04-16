public int[][] gtree(int n) throws IOException {
    int[][] adja = new int[n + 1][];
    int[] from = new int[n - 1];
    int[] to = new int[n - 1];
    int[] count = new int[n + 1];
    for (int i = 0; i < n - 1; i++) {
        from[i] = i + 1;
        to[i] = ni();
        count[from[i]]++;
        count[to[i]]++;
    }
    for (int i = 0; i <= n; i++) {
        adja[i] = new int[count[i]];
    }
    for (int i = 0; i < n - 1; i++) {
        adja[from[i]][--count[from[i]]] = to[i];
        adja[to[i]][--count[to[i]]] = from[i];
    }
    return adja;
}