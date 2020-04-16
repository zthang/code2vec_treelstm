static boolean dfs(int i, int p, int c, boolean minus) {
    if (graph.get(i).size() > 2)
        return false;
    pos[i] = c;
    for (int j : graph.get(i)) if (j != p) {
        if (!dfs(j, i, minus ? (c + 2) % 3 : (c + 1) % 3, minus))
            return false;
        minus = true;
    }
    return true;
}