static void solve() throws IOException {
    // initIo(true);
    initIo(false);
    StringBuilder sb = new StringBuilder();
    int n = ni();
    int[] x = new int[n], y = new int[n];
    for (int i = 0; i < n; ++i) {
        x[i] = ni();
        y[i] = ni();
    }
    int[] indep_cost = new int[n];
    for (int i = 0; i < n; ++i) {
        indep_cost[i] = ni();
    }
    int[] k = new int[n];
    for (int i = 0; i < n; ++i) {
        k[i] = ni();
    }
    long[] cost = new long[n];
    PriorityQueue<Tuple> queue = new PriorityQueue<>();
    boolean[] vis = new boolean[n];
    for (int i = 0; i < n; ++i) {
        queue.add(new Tuple(i, indep_cost[i], -1));
        cost[i] = indep_cost[i];
    }
    ArrayList<Integer> directs = new ArrayList<>();
    ArrayList<Integer> indx = new ArrayList<>();
    ArrayList<Integer> indy = new ArrayList<>();
    long ans = 0;
    while (!queue.isEmpty()) {
        Tuple min = queue.poll();
        // pl("min : " + min);
        if (vis[min.node]) {
            continue;
        }
        ans += min.cost;
        if (min.through == -1) {
            directs.add(min.node);
        } else {
            indx.add(min.node);
            indy.add(min.through);
        }
        int node = min.node;
        vis[min.node] = true;
        for (int i = 0; i < n; ++i) {
            if (cost[i] > 1L * (k[i] + k[node]) * (abs(x[node] - x[i]) + abs(y[node] - y[i]))) {
                cost[i] = 1L * (k[i] + k[node]) * (abs(x[node] - x[i]) + abs(y[node] - y[i]));
                queue.add(new Tuple(i, cost[i], node));
            }
        }
    }
    pl(ans);
    pl(directs.size());
    for (int e : directs) {
        p((e + 1));
    }
    pl();
    ;
    pl(indx.size());
    for (int i = 0; i < indx.size(); ++i) {
        pl((indx.get(i) + 1) + " " + (indy.get(i) + 1));
    }
    pw.flush();
    pw.close();
}