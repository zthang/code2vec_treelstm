static void solve() {
    int n = ir.nextInt();
    int k = ir.nextInt();
    int[][] a = new int[k][];
    for (int i = 0; i < k; i++) a[i] = ir.nextIntArray(2);
    UnionFindTree uf = new UnionFindTree(n);
    for (int i = 0; i < k; i++) {
        uf.unite(a[i][0] - 1, a[i][1] - 1);
    }
    boolean[] f = new boolean[n];
    int res = 0;
    for (int i = 0; i < n; i++) {
        if (f[uf.find(i)])
            continue;
        f[uf.find(i)] = true;
        res += uf.size(i) - 1;
    }
    out.println(k - res);
}