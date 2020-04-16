static void init() {
    depth = new int[n];
    MAX_LOG_n = Integer.toBinaryString(n).length();
    parent = new int[MAX_LOG_n][n];
    Arrays.fill(depth, -1);
    parent[0][0] = -1;
    dfs(0, 0);
    for (int k = 0; k + 1 < MAX_LOG_n; k++) {
        for (int v = 0; v < n; v++) {
            if (parent[k][v] < 0)
                parent[k + 1][v] = -1;
            else
                parent[k + 1][v] = parent[k][parent[k][v]];
        }
    }
}