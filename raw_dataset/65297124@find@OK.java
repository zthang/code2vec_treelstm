// Returns representative of x's set
int find(int x) {
    // that x is an element of
    if (parent[x] != x) {
        // if x is not the parent of itself
        // Then x is not the representative of
        // his set,
        parent[x] = find(parent[x]);
    // so we recursively call Find on its parent
    // and move i's node directly under the
    // representative of this set
    }
    return parent[x];
}