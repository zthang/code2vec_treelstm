private int check(List<Integer>[] edges, int n) {
    boolean[][] used = new boolean[8][8];
    int tot = 0;
    for (int i = 0; i < n; i++) {
        for (int v : edges[i]) {
            if (vis[i] <= vis[v] && !used[vis[i]][vis[v]]) {
                used[vis[i]][vis[v]] = true;
                tot++;
            }
        }
    }
    return tot;
}