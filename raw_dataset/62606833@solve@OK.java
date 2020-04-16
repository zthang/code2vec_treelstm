public void solve(int testNumber, FastInput in, PrintWriter out) {
    int n = in.ni();
    long[][] cost = new long[3][n];
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < n; ++j) {
            cost[i][j] = in.nl();
        }
    }
    ArrayList<Integer>[] tree = new ArrayList[n];
    for (int i = 0; i < n; ++i) tree[i] = new ArrayList<>();
    int leaf = -1;
    for (int i = 0; i < n - 1; ++i) {
        int u = in.ni(), v = in.ni();
        u--;
        v--;
        tree[u].add(v);
        tree[v].add(u);
        if (tree[u].size() > 2 || tree[v].size() > 2) {
            out.println(-1);
            return;
        }
    }
    for (int i = 0; i < n; ++i) {
        if (tree[i].size() == 1)
            leaf = i;
    }
    // out.println(leaf);
    dfs(tree, leaf, -1, 0);
    // out.println(map);
    long[] ans = new long[n];
    Arrays.fill(ans, Integer.MAX_VALUE);
    long[] indans = new long[n];
    long[] currans;
    for (int i = 0; i < 6; ++i) {
        currans = new long[n];
        dfs(tree, currans, cost, leaf, -1, permutation[i], 0);
        long sum = LongStream.of(currans).sum();
        long sum2 = LongStream.of(ans).sum();
        if (sum < sum2) {
            ans = Arrays.copyOfRange(currans, 0, n);
            for (int j = 0; j < n; ++j) {
                // out.print(permutation[i][j%3]+" ");
                // indans[map.get(j)]=permutation[i][j%3];
                indans[j] = permap.get(j);
            }
        // out.println();
        }
    // out.println(Arrays.toString(permutation[i]));
    // out.println(sum);
    // out.println(Arrays.toString(currans));
    }
    out.println(LongStream.of(ans).sum());
    for (int i = 0; i < n; ++i) {
        out.print(indans[i] + " ");
    }
}