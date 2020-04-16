void solve() {
    StringBuffer sb = new StringBuffer();
    int n = ni();
    int K = ni();
    UnionFind uf = new UnionFind(n + 1);
    for (int i = 0; i < K; i++) uf.union(ni(), ni());
    int ans = 0;
    int pre = MAX;
    for (int i = n; i > 0; i--) {
        int cur = uf.find(i);
        if (cur < pre)
            pre = cur;
        else if (cur > pre) {
            uf.union(pre, cur);
            ans++;
        }
    }
    // sb.append(System.lineSeparator());
    out.println(ans);
}