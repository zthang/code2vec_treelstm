public static final int[][] packDirectedUnweighted(int[][] edges, int n) {
    int[][] g = new int[n + 1][];
    int[] size = new int[n + 1];
    for (int[] edge : edges) {
        ++size[edge[0]];
    }
    for (int i = 0; i <= n; i++) {
        g[i] = new int[size[i]];
    }
    for (int[] edge : edges) {
        g[edge[0]][--size[edge[0]]] = edge[1];
    }
    return g;
}