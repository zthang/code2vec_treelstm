int find(int[][] set, int u) {
    return set[u][0] = (set[u][0] == u ? u : find(set, set[u][0]));
}