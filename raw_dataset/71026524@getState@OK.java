private static int getState(int[][] grid, int i) {
    if (i == 0 || i >= grid[0].length)
        return 0;
    int x = grid[0][i - 1] + 2 * (grid[1][i - 1] + 2 * (grid[0][i] + 2 * (grid[1][i])));
    return x;
}