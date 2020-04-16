private static void dfs(int cur) {
    col[cur] = 1;
    for (int[] p : g[cur]) {
        int next = p[0];
        int id = p[1];
        if (col[next] == 0) {
            dfs(next);
            res[id] = 1;
        } else if (col[next] == 2) {
            res[id] = 1;
        } else {
            res[id] = 2;
            cycle = true;
        }
    }
    col[cur] = 2;
}