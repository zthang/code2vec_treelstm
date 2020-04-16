public int[][][] gwg(int n, int m) throws IOException {
    int[][] adja = new int[n + 1][];
    int[][] weight = new int[n + 1][];
    int[] from = new int[m];
    int[] to = new int[m];
    int[] count = new int[n + 1];
    int[] cost = new int[n + 1];
    for (int i = 0; i < m; i++) {
        from[i] = ni();
        to[i] = ni();
        cost[i] = ni();
        count[from[i]]++;
        count[to[i]]++;
    }
    for (int i = 0; i <= n; i++) {
        adja[i] = new int[count[i]];
        weight[i] = new int[count[i]];
    }
    for (int i = 0; i < m; i++) {
        adja[from[i]][count[from[i]] - 1] = to[i];
        adja[to[i]][count[to[i]] - 1] = from[i];
        weight[from[i]][count[from[i]] - 1] = cost[i];
        weight[to[i]][count[to[i]] - 1] = cost[i];
        count[from[i]]--;
        count[to[i]]--;
    }
    return new int[][][] { adja, weight };
}