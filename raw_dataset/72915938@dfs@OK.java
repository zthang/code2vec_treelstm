static void dfs(int i, int j) {
    for (int k = 0; k < 4; k++) {
        int newI = i + di[k], newJ = j + dj[k];
        if (valid(newI, newJ) && ans[newI][newJ] == '#' && grid[newI][newJ] == grid[i][j]) {
            ans[newI][newJ] = oppDir[k];
            dfs(newI, newJ);
        }
    }
}