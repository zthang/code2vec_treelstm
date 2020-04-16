public void solve() {
    int t = 1;
    while (t-- > 0) {
        int n = sc.ni();
        int m = sc.ni();
        int k = sc.ni();
        int[] krr = new int[k];
        for (int i = 0; i < k; i++) krr[i] = sc.ni() - 1;
        visit = new int[n];
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList();
        for (int i = 0; i < m; i++) {
            int x = sc.ni() - 1;
            int y = sc.ni() - 1;
            adj[x].add(y);
            adj[y].add(x);
        }
        Node[] nrr = new Node[k];
        for (int i = 0; i < k; i++) nrr[i] = new Node(krr[i]);
        int[] level = new int[n];
        bfs(0, level);
        int ans = level[n - 1];
        for (int i = 0; i < k; i++) nrr[i].x = level[nrr[i].val];
        Arrays.fill(level, 0);
        Arrays.fill(visit, 0);
        bfs(n - 1, level);
        for (int i = 0; i < k; i++) nrr[i].y = level[nrr[i].val];
        Arrays.sort(nrr);
        PriorityQueue<Node> pq = new PriorityQueue(k, new Comparator<Node>() {

            @Override
            public int compare(Node p, Node q) {
                return q.y - p.y;
            }
        });
        int tmp = -1;
        pq.add(nrr[k - 1]);
        for (int i = k - 2; i >= 0; i--) {
            Node p = (Node) pq.peek();
            tmp = Math.max(tmp, nrr[i].x + 1 + p.y);
            pq.add(nrr[i]);
        }
        pw.println(Math.min(ans, tmp));
    }
}