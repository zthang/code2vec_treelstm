void work() {
    int n = ni(), q = ni();
    ret = new int[q];
    dep = new int[n];
    graph = ng(n, n - 1);
    Q = (ArrayList<int[]>[]) new ArrayList[n];
    for (int i = 0; i < n; i++) Q[i] = new ArrayList<>();
    dfs1(0, new boolean[n], 0);
    for (int i = 0; i < q; i++) {
        int l = ni();
        int node = -1, d = -1;
        int[] A = new int[l + 1];
        A[0] = i;
        for (int j = 1; j < l + 1; j++) {
            A[j] = ni() - 1;
            int nn = A[j];
            if (dep[nn] > d) {
                node = nn;
                d = dep[nn];
            }
        }
        Q[node].add(A);
    }
    dfs2(0, new boolean[n], -1);
    for (int r : ret) {
        if (r == 1) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    }
}