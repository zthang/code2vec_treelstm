public static long union(int[] parent, int[] size, int u, int v) {
    int par1 = find(parent, u);
    int par2 = find(parent, v);
    if (par1 == par2)
        return 0;
    int size1 = size[par1];
    int size2 = size[par2];
    long change = ncr(size1 + size2) - ncr(size1) - ncr(size2);
    parent[par1] = par2;
    size[par2] = size[par1] + size[par2];
    return change;
}