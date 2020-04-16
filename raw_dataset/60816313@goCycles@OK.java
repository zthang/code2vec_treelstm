private boolean goCycles(int from, int s, int[][] g, boolean[] used, boolean[] cycled) {
    if (used[s]) {
        return true;
    }
    used[s] = true;
    boolean result = false;
    for (int e = 0; e < g[s].length; e++) {
        if (g[s][e] == from) {
            continue;
        }
        if (goCycles(s, g[s][e], g, used, cycled)) {
            result = true;
        }
    }
    cycled[s] = result;
    return result;
}