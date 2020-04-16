void solve() throws Exception {
    int i, j, k;
    N = hp.nextInt();
    long[][] C = new long[3][];
    for (i = 0; i < 3; ++i) C[i] = hp.getLongArray(N);
    graph = new ArrayList[N];
    for (i = 0; i < N; ++i) graph[i] = new ArrayList<>();
    for (i = 0; i < N - 1; ++i) {
        int a = hp.nextInt() - 1, b = hp.nextInt() - 1;
        graph[a].add(b);
        graph[b].add(a);
    }
    int root = 0;
    for (; graph[root].size() > 1; ++root) ;
    dfsOrder = new ArrayList<>();
    if (dfs(root, -7)) {
        ArrayList<Integer> cols = new ArrayList<>();
        cols.add(0);
        cols.add(1);
        cols.add(2);
        long ans = Long.MAX_VALUE >> 2;
        int[] assign = null;
        for (i = 0; i < 77; ++i) {
            Collections.shuffle(cols);
            long cost = 0;
            for (j = 0; j < N; ++j) cost += C[cols.get(j % 3)][dfsOrder.get(j)];
            if (cost < ans) {
                ans = cost;
                assign = new int[N];
                for (j = 0; j < N; ++j) assign[dfsOrder.get(j)] = cols.get(j % 3) + 1;
            }
        }
        hp.println(ans);
        hp.println(hp.joinElements(assign));
    } else {
        hp.println(-1);
    }
    hp.flush();
}