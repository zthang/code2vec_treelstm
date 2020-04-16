static int getparent(int p, int[] parent) {
    if (parent[p] == p)
        return p;
    parent[p] = getparent(parent[p], parent);
    return parent[p];
}