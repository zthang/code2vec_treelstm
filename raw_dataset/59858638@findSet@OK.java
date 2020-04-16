public int findSet(int v) {
    if (subset[v].parent == v)
        return v;
    return subset[v].parent = findSet(subset[v].parent);
}