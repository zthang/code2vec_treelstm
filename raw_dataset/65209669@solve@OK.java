private static void solve(int q, FastScanner in, PrintWriter out) {
    for (int c = 0; c < q; c++) {
        int n = in.nextInt(), m = in.nextInt();
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = in.nextInt();
            edges[i][1] = in.nextInt();
        }
        UnionFind uf = new UnionFind(n);
        // connect nodes using initial edges
        for (int i = 0; i < m; i++) {
            uf.union(edges[i][0] - 1, edges[i][1] - 1);
        }
        int add = 0;
        Set<Integer> checked = new HashSet<>();
        // update the min node number to be the smaller of the 2 components.
        for (int i = n - 1; i >= 0; i--) {
            if (checked.contains(i)) {
                continue;
            }
            int root = uf.find(i);
            if (uf.sz[root] > 1) {
                int upper = uf.range[root][1];
                int lower = uf.range[root][0];
                int j = upper;
                while (j >= lower) {
                    int root1 = uf.find(j);
                    root = uf.find(i);
                    if (root != root1) {
                        lower = Math.min(lower, uf.range[root1][0]);
                        add++;
                        uf.union(root, root1);
                    }
                    checked.add(j);
                    j--;
                }
            }
        }
        out.println(add);
    }
    out.close();
}