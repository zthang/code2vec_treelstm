int[][] makeU(int n, int[][] edge) {
    int[][] g = new int[n][];
    int[] cnt = new int[n];
    for (int i = 0; i < edge.length; i++) {
        cnt[edge[i][0]]++;
        cnt[edge[i][1]]++;
    }
    for (int i = 0; i < n; i++) g[i] = new int[cnt[i]];
    for (int i = 0; i < edge.length; i++) {
        g[edge[i][0]][--cnt[edge[i][0]]] = edge[i][1];
        g[edge[i][1]][--cnt[edge[i][1]]] = edge[i][0];
    }
    return g;
}