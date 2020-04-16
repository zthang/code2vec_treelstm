public void solve(int testNumber, InputReader sc, PrintWriter out) {
    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int q = sc.nextInt();
    Edge[] e = new Edge[m];
    ArrayList<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < n; ++i) adj[i] = new ArrayList<>();
    for (int i = 0; i < m; ++i) {
        e[i] = new Edge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextLong());
        adj[e[i].u].add(i);
        adj[e[i].v].add(i);
    }
    long[] minCost = new long[n];
    Arrays.fill(minCost, Long.MAX_VALUE);
    int[] vis = new int[n];
    PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {

        public int compare(Pair o1, Pair o2) {
            if (o1.cost < o2.cost)
                return -1;
            if (o1.cost > o2.cost)
                return 1;
            return 0;
        }
    });
    for (int i = 0; i < k; ++i) {
        queue.add(new Pair(i, 0));
        minCost[i] = 0;
    }
    while (!queue.isEmpty()) {
        Pair curP = queue.poll();
        int ind = curP.ind;
        long cost = curP.cost;
        if (vis[ind] == 1)
            continue;
        vis[ind] = 1;
        for (int edgeInd : adj[ind]) {
            Edge curE = e[edgeInd];
            int j = curE.findAnother(ind);
            long curCost = cost + curE.w;
            if (curCost < minCost[j]) {
                minCost[j] = curCost;
                queue.add(new Pair(j, curCost));
            }
        }
    }
    for (int i = 0; i < m; ++i) {
        e[i].cost = minCost[e[i].u] + minCost[e[i].v] + e[i].w;
    }
    Arrays.sort(e, new Comparator<Edge>() {

        public int compare(Edge o1, Edge o2) {
            if (o1.cost < o2.cost)
                return -1;
            if (o1.cost > o2.cost)
                return 1;
            return 0;
        }
    });
    query = new HashSet[n];
    for (int i = 0; i < n; ++i) query[i] = new HashSet<>();
    for (int i = 0; i < q; ++i) {
        int u = sc.nextInt() - 1;
        int v = sc.nextInt() - 1;
        query[u].add(i);
        query[v].add(i);
    }
    par = new int[n];
    for (int i = 0; i < n; ++i) par[i] = i;
    ans = new long[q];
    for (int i = 0; i < m; ++i) {
        // out.println((e[i].u + 1) + " " + (e[i].v + 1) + " " + e[i].w + " " + minCost[e[i].u] + " " + minCost[e[i].v] + " " + e[i].cost);
        cans = e[i].cost;
        union(e[i].u, e[i].v);
    }
    for (int i = 0; i < q; ++i) out.print(ans[i] + " ");
}