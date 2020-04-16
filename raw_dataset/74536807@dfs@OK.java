static void dfs(int s, int p) {
    up[s][0] = p;
    for (Integer x : graph[s]) {
        if (x == p)
            continue;
        lvl[x] = 1 + lvl[s];
        dfs(x, s);
    }
}