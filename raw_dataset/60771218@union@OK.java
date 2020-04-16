public static void union(int[] parent, int u, int v, int[] count) {
    int par1 = find(parent, u);
    int par2 = find(parent, v);
    if (par1 == par2)
        return;
    parent[par1] = par2;
    count[par2] = count[par2] + count[par1] + 1;
}