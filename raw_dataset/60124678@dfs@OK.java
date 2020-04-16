boolean dfs(int c) {
    int[] D = new int[n + 1];
    boolean f = true;
    for (int x = 1; x <= n; x++) {
        if (D[x] == 0) {
            if (!dfs2(x, c, D))
                f = false;
        }
    }
    return f;
}