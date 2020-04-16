public void solve(int testNumber, FastInput in, FastOutput out) {
    int k = in.readInt();
    int n = k * 2;
    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) {
        nodes[i] = new Node();
        nodes[i].id = i;
    }
    for (int i = 1; i < n; i++) {
        Node a = nodes[in.readInt() - 1];
        Node b = nodes[in.readInt() - 1];
        Edge e = new Edge();
        e.a = a;
        e.b = b;
        e.length = in.readInt();
        a.next.add(e);
        b.next.add(e);
    }
    dfsForSize(nodes[0], null);
    long minLCA = dfsForMinLCA(nodes[0], 0);
    dfsForDp(nodes[0], null);
    long good = nodes[0].dp;
    long bad = 0;
    for (int i = 0; i < n; i++) {
        bad += nodes[i].depth;
    }
    bad -= 2 * minLCA;
    out.append(good).append(' ').append(bad).append('\n');
}