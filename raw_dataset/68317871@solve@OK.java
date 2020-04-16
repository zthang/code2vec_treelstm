public void solve(int testNumber, FastInput in, FastOutput out) {
    this.out = out;
    int n = in.readInt();
    t1 = new Node[n + 1];
    t2 = new Node[n + 1];
    MultiWayIntegerStack edges = new MultiWayIntegerStack(n + 1, (n + 1) * 2);
    edges.addLast(0, 1);
    for (int i = 1; i <= n; i++) {
        t1[i] = new Node();
        t1[i].id = i;
        t2[i] = new Node();
        t2[i].id = i;
    }
    for (int i = 1; i < n; i++) {
        Node a = t1[in.readInt()];
        Node b = t1[in.readInt()];
        addEdge(a, b);
        edges.addLast(a.id, b.id);
        edges.addLast(b.id, a.id);
    }
    lcaOnTree = new LcaOnTree(edges, 0);
    for (int i = 1; i < n; i++) {
        Node a = t2[in.readInt()];
        Node b = t2[in.readInt()];
        addEdge(a, b);
    }
    out.println(n - 1);
    dfsT1(t1[1], null, 0);
    dfsT2(t2[1], null);
}