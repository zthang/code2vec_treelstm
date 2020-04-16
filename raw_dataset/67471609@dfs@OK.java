public static void dfs(int[][] g, int[] nd, int root) {
    for (int i = 0; i < 26; i++) {
        if (g[i][root] == 1)
            g[i][root] = 2;
    }
    for (int i = 0; i < 26; i++) {
        if (g[root][i] == 1) {
            nd[i] = 2;
            dfs(g, nd, i);
        }
    }
}