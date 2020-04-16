static void dfs(int a) {
    id[a] = 1;
    int b, e;
    for (Pair p : g[a]) {
        b = p.x;
        e = p.y;
        if (id[b] == 0) {
            res[e] = 1;
            dfs(b);
        } else if (id[b] == 2) {
            res[e] = 1;
        } else {
            c = 2;
            res[e] = 2;
        }
    }
    id[a] = 2;
}