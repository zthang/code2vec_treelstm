public static int lca(int a, int b) {
    if (depth[a] < depth[b]) {
        // swap a and b
        int temp = a;
        a = b;
        b = temp;
    }
    for (int i = MAXD - 1; i >= 0; i--) {
        if (((depth[a] - depth[b]) & (1 << i)) != 0) {
            // if(depth[a] - (1<<i) > depth[b]){
            a = lca[a][i];
        }
    }
    if (a == b)
        return a;
    for (int i = MAXD - 1; i >= 0; i--) {
        if (lca[a][i] != lca[b][i]) {
            a = lca[a][i];
            b = lca[b][i];
        }
    }
    return lca[a][0];
}