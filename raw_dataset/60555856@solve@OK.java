void solve() {
    int n = in.nextInt();
    int m = in.nextInt();
    List<Edge>[] g = new List[n];
    for (int i = 0; i < n; i++) {
        g[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
        int fr = in.nextInt() - 1;
        int to = in.nextInt() - 1;
        g[fr].add(new Edge(to, (i + 1) + ""));
        g[to].add(new Edge(fr, (i + 1) + ""));
    }
    int root = getNode(0, 0, 0);
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    dp[0] = root;
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(0, root));
    boolean[] was = new boolean[n];
    while (!pq.isEmpty()) {
        Node node = pq.poll();
        if (was[node.vertex]) {
            continue;
        }
        for (Edge e : g[node.vertex]) {
            if (!was[e.to]) {
                int len = getNext(node.len, e.s);
                if (dp[e.to] == -1 || cmp(len, dp[e.to]) < 0) {
                    dp[e.to] = len;
                    pq.add(new Node(e.to, len));
                }
            }
        }
    }
    for (int i = 1; i < n; i++) {
        out.println(hash[dp[i]]);
    }
}