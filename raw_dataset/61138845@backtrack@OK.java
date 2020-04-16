static public int backtrack(int current, int[] colors, int[] used, int[][] vertex) {
    if (current == colors.length) {
        return check(colors, vertex);
    }
    // backtrack(current + 1, colors, used,vertex);
    int max = 0;
    for (int i = 1; i <= 6; i++) {
        // if (used[i] == 0) {
        // used[i] = 1;
        colors[current] = i;
        max = Math.max(max, backtrack(current + 1, colors, used, vertex));
        colors[current] = 0;
    // used[i] = 0;
    // }
    }
    return max;
}