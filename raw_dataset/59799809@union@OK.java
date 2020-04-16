public void union(int v, int u) {
    int parentV = getParentOfSubset(v);
    int parentU = getParentOfSubset(u);
    if (parentV == parentU)
        return;
    count = count + subset[parentV].size * subset[parentU].size;
    if (subset[parentV].size < subset[parentU].size) {
        subset[parentV].parent = parentU;
        subset[parentU].size += subset[parentV].size;
    } else {
        subset[parentU].parent = parentV;
        subset[parentV].size += subset[parentU].size;
    }
}