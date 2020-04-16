static int find(int x, int[] parent) {
    // that x is an element of
    while (parent[x] != x) {
        // if x is not the parent of itself
        // Then x is not the representative of
        // his set,
        x = parent[x];
    // so we recursively call Find on its parent
    // and move i's node directly under the
    // representative of this set
    }
    return x;
}