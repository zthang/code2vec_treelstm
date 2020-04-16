public void union(int v, int u) {
    int parentV = findSet(v);
    int parentU = findSet(u);
    if (parentV == parentU)
        return;
    res = res - subset[parentV].size * (subset[parentV].size - 1) / 2;
    res = res - subset[parentU].size * (subset[parentU].size - 1) / 2;
    long s = subset[parentU].size + subset[parentV].size;
    res = res + s * (s - 1) / 2;
    if (subset[parentV].size < subset[parentU].size) {
        subset[parentV].parent = parentU;
        subset[parentU].size += subset[parentV].size;
    } else {
        subset[parentU].parent = parentV;
        subset[parentV].size += subset[parentU].size;
    }
}