public void go() throws IOException {
    ntok();
    int n = ipar();
    int m = ipar();
    int[][] edges = new int[n - 1][];
    for (int i = 0; i < n - 1; i++) {
        ntok();
        edges[i] = new int[] { ipar(), ipar(), ipar() };
    }
    long[][] queries = new long[m][3];
    ntok();
    for (int i = 0; i < m; i++) {
        queries[i][0] = ipar();
        queries[i][1] = i;
    }
    Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
    Arrays.sort(queries, (a, b) -> Long.compare(a[0], b[0]));
    long total = 0;
    int q = 0;
    UnionFind uf = new UnionFind(n);
    OUTER: for (int[] edge : edges) {
        while (edge[2] > queries[q][0]) {
            queries[q][2] = total;
            q++;
            if (q == m) {
                break OUTER;
            }
        }
        int i = uf.find(edge[0] - 1);
        int j = uf.find(edge[1] - 1);
        if (i != j) {
            total += uf.sz[i] * uf.sz[j];
            uf.union(i, j);
        }
    }
    while (q < m) {
        queries[q][2] = total;
        q++;
    }
    Arrays.sort(queries, (a, b) -> Long.compare(a[1], b[1]));
    for (int i = 0; i < m; i++) {
        if (i != 0) {
            out.print(" ");
        }
        out.print(queries[i][2]);
    }
    out.println();
    out.flush();
    in.close();
}