private long findMax(int from, int s, int[][] g, int[] w, boolean[] used) {
    if (used[s]) {
        return 0;
    }
    used[s] = true;
    long result = 0;
    for (int e = 0; e < g[s].length; e++) {
        if (g[s][e] == from) {
            continue;
        }
        result = Math.max(result, findMax(s, g[s][e], g, w, used));
    }
    return result + w[s];
}