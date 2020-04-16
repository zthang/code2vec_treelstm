static void dfs(int v) {
    col[v] = 1;
    for (Pair p : list.get(v)) {
        if (col[p.first] == 0) {
            dfs(p.first);
            res[p.second] = 1;
        } else if (col[p.first] == 2) {
            res[p.second] = 1;
        } else {
            cyc = true;
            res[p.second] = 2;
        }
    }
    col[v] = 2;
}