private boolean cycle(int n) {
    int[] color = new int[n + 1];
    Arrays.fill(color, 0);
    for (int i = 1; i <= n; i++) {
        if (color[i] == 0) {
            if (dfs(i, color)) {
                return true;
            }
        }
    }
    return false;
}