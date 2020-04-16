public void solve(int testNumber, FastInput in, FastOutput out) {
    int n = in.readInt();
    int m = in.readInt();
    int k = in.readInt();
    int q = in.readInt();
    Node[] nodes = new Node[n + 1];
    for (int i = 1; i <= n; i++) {
        nodes[i] = new Node();
        nodes[i].id = i;
    }
    Edge[] edges = new Edge[m];
    for (int i = 0; i < m; i++) {
        edges[i] = new Edge();
        edges[i].a = nodes[in.readInt()];
        edges[i].b = nodes[in.readInt()];
        edges[i].w = in.readInt();
        edges[i].a.next.add(edges[i]);
        edges[i].b.next.add(edges[i]);
    }
    for (int i = k + 1; i <= n; i++) {
        nodes[i].dist = (long) 1e18;
    }
    TreeSet<Node> set = new TreeSet<>((a, b) -> a.dist == b.dist ? a.id - b.id : Long.compare(a.dist, b.dist));
    for (int i = 1; i <= k; i++) {
        nodes[i].dist = 0;
        set.add(nodes[i]);
    }
    while (!set.isEmpty()) {
        Node head = set.pollFirst();
        for (Edge e : head.next) {
            Node node = e.other(head);
            if (head.dist + e.w >= node.dist) {
                continue;
            }
            set.remove(node);
            node.dist = head.dist + e.w;
            set.add(node);
        }
    }
    for (Edge e : edges) {
        e.w += e.a.dist + e.b.dist;
    }
    Arrays.sort(edges, (a, b) -> Long.compare(a.w, b.w));
    Query[] qs = new Query[q];
    for (int i = 0; i < q; i++) {
        qs[i] = new Query();
        qs[i].a = nodes[in.readInt()];
        qs[i].b = nodes[in.readInt()];
    }
    dac(edges, 0, m - 1, qs.clone(), 0, q - 1);
    for (int i = 0; i < q; i++) {
        out.println(qs[i].ans);
    }
}