public void dfs(int i, int j, int from, int to) {
    if (!check(i, j)) {
        return;
    }
    if (ans[i][j] != 0) {
        return;
    }
    if (mat[i][j][0] != mat[from][to][0] || mat[i][j][1] != mat[from][to][1]) {
        return;
    }
    ans[i][j] = get(i, j, from, to);
    for (int[] dir : dirs) {
        int ni = dir[0] + i;
        int nj = dir[1] + j;
        dfs(ni, nj, i, j);
    }
}