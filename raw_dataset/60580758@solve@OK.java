public void solve(int testNumber, FastReader scan, PrintWriter out) {
    int n = scan.nextInt(), k = scan.nextInt(), t = 0;
    DSU set = new DSU(n + 1);
    for (int i = 0; i < k; i++) set.unite(scan.nextInt(), scan.nextInt());
    for (int i = 1; i <= n; i++) {
        if (set.parent[i] == i) {
            t += set.size[i] - 1;
        }
    }
    out.println(k - t);
}