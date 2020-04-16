static int[][] adjD(int n, int[] from, int[] to) {
    int[][] adj = new int[n][];
    int[] cnt = new int[n];
    for (int f : from) {
        cnt[f]++;
    }
    for (int i = 0; i < n; i++) {
        adj[i] = new int[cnt[i]];
    }
    for (int i = 0; i < from.length; i++) {
        adj[from[i]][--cnt[from[i]]] = to[i];
    }
    return adj;
}