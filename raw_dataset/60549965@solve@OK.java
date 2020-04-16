public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt(), k = in.nextInt();
    UnionFind uf = new UnionFind(n);
    for (int i = 0; i < k; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        uf.union(a, b);
    }
    int happy = 0;
    for (int i = 0; i < n; i++) {
        if (uf.rep(i) == i) {
            happy += uf.size(i) - 1;
        }
    }
    out.println(k - happy);
}