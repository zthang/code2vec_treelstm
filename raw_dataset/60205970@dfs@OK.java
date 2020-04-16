private boolean dfs(int s, int[] color) {
    color[s] = 1;
    for (int j : a[s]) {
        if (color[j] == 1) {
            return true;
        }
        if (color[j] == 0 && dfs(j, color)) {
            return true;
        }
    }
    color[s] = 2;
    return false;
}