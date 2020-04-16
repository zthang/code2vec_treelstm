void run() {
    int n = nextInt();
    int m = nextInt();
    Node[] min = new Node[n + 1];
    List<Edge>[] g = new List[n + 1];
    for (int i = 0; i <= n; i++) {
        g[i] = new ArrayList<Edge>();
    }
    for (int i = 1; i <= m; i++) {
        int u = nextInt(), v = nextInt();
        Edge edge = new Edge(i, u, v);
        g[u].add(edge);
        g[v].add(edge);
    }
    Node s = min[1] = new Node(null, 0, 1);
    PriorityQueue<Node> queue = new PriorityQueue<>();
    queue.add(s);
    while (!queue.isEmpty()) {
        Node node = queue.poll();
        if (min[node.id].compareTo(node) == 0) {
            for (Edge edge : g[node.id]) {
                int v = edge.to(node.id);
                Node tmp = get(node, v, edge.id);
                if (min[v] == null || min[v].compareTo(tmp) > 0) {
                    min[v] = tmp;
                    queue.add(tmp);
                }
            }
        }
    }
    for (int i = 2; i <= n; i++) {
        println(min[i].hash);
    }
}