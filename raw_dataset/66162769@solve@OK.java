void solve() {
    StringBuffer sb = new StringBuffer();
    int N = ni();
    UnionFind uf = new UnionFind(128);
    while (N-- > 0) {
        char[] a = ns().toCharArray();
        for (int i = 0; i < a.length - 1; i++) uf.union(a[i], a[i + 1]);
        if (a.length == 1)
            uf.find(a[0]);
    }
    out.print(uf.count());
}