public static void union(int[] parent, int u, int v, int[] size, int[] max) {
    int par1 = find(parent, u);
    int par2 = find(parent, v);
    if (par1 == par2)
        return;
    if (par1 > par2) {
        int temp = par1;
        par1 = par2;
        par2 = temp;
    }
    parent[par2] = par1;
    size[par1] = size[par2] + size[par1];
    max[par1] = Math.max(max[par1], max[par2]);
}