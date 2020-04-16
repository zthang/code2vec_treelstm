int lca(int x, int y) {
    for (int i = up.length - 1; i >= 0; i--) {
        if (up[i][x] != up[i][y]) {
            x = up[i][x];
            y = up[i][y];
        }
    }
    return Integer.compare(prev[x], prev[y]);
}