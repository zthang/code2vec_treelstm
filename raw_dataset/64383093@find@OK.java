int find(int[] set, int u) {
    return set[u] = (set[u] == u ? u : find(set, set[u]));
}