static void dfs(int u) {
    in[u] = 1;
    for (pair s : ad[u]) {
        if (in[s.x] == 0) {
            ans[s.y] = 1;
            dfs(s.x);
        } else if (in[s.x] == 1) {
            k = 2;
            ans[s.y] = 2;
        } else
            ans[s.y] = 1;
    }
    in[u] = 2;
}