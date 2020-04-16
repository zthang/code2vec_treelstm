public int getParentOfSubset(int v) {
    if (subset[v].parent == v)
        return v;
    return subset[v].parent = getParentOfSubset(subset[v].parent);
}