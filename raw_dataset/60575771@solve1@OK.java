public void solve1() {
    int n = io.readInt();
    int m = io.readInt();
    Node[] nodes = new Node[1 + n];
    Tries tries = new Tries();
    for (int i = 1; i <= n; i++) {
        nodes[i] = new Node();
        nodes[i].id = i;
        nodes[i].which = Tries.Node.inf;
    }
    for (int i = 1; i <= m; i++) {
        Node a = nodes[io.readInt()];
        Node b = nodes[io.readInt()];
        Edge e = new Edge();
        e.a = a;
        e.b = b;
        e.number = i;
        a.edge.add(e);
        b.edge.add(e);
    }
    TreeSet<Node> set = new TreeSet<>((a, b) -> a.which == b.which ? a.id - b.id : Tries.Node.cmp(a.which, b.which));
    nodes[1].which = tries.root;
    for (int i = 1; i <= n; i++) {
        set.add(nodes[i]);
    }
    while (!set.isEmpty()) {
        Node head = set.pollFirst();
        for (Edge e : head.edge) {
            Node node = e.a == head ? e.b : e.a;
            Tries.Node dist = tries.get(head.which, e.number);
            if (Tries.Node.cmp(dist, node.which) >= 0) {
                continue;
            }
            set.remove(node);
            node.which = dist;
            set.add(node);
        }
    }
    for (int i = 2; i <= n; i++) {
        io.cache.append(nodes[i].which.prefix).append('\n');
    }
}