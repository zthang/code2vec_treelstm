int find(int[][] set, int u) {
    return set[0][u] = (set[0][u] == u ? u : find(set, set[0][u]));
}