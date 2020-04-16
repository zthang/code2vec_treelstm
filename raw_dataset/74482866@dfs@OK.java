public static void dfs(int x, int p) {
    for (int y : list[x]) {
        if (y == p) {
            continue;
        }
        par[y][0] = x;
        lev[y] = lev[x] + 1;
        dfs(y, x);
    }
}