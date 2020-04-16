public static int dfs(int depth, int[] guesses, int[][] edges) {
    if (depth == guesses.length) {
        int[][] dominos = new int[6][6];
        for (int i = 0; i < 6; ++i) {
            for (int j = i; j < 6; ++j) {
                dominos[i][j] = 0;
            }
        }
        for (int i = 0; i < edges.length; ++i) {
            dominos[guesses[edges[i][0]]][guesses[edges[i][1]]] = 1;
            dominos[guesses[edges[i][1]]][guesses[edges[i][0]]] = 1;
        }
        int count = 0;
        for (int i = 0; i < 6; ++i) {
            for (int j = i; j < 6; ++j) {
                count += dominos[i][j];
            }
        }
        return count;
    }
    int max = 0;
    for (int i = 0; i < 6; ++i) {
        guesses[depth] = i;
        int tempCount = dfs(depth + 1, guesses, edges);
        max = Math.max(max, tempCount);
    }
    return max;
}