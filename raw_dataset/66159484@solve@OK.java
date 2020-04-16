public void solve(int testNumber, FastInput in, FastOutput out) {
    int n = in.readInt();
    int k = in.readInt();
    int[] p = new int[n];
    int[] q = new int[n];
    for (int i = 0; i < n; i++) {
        p[i] = in.readInt() - 1;
    }
    for (int i = 0; i < n; i++) {
        q[i] = in.readInt() - 1;
    }
    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) {
        nodes[i] = new Node();
    }
    for (int i = 1; i < n; i++) {
        nodes[q[i]].next.add(nodes[q[i - 1]]);
        nodes[p[i]].next.add(nodes[p[i - 1]]);
    }
    int distinct = 0;
    for (Node node : nodes) {
        tarjan(node);
        if (node == node.set) {
            distinct++;
        }
    }
    if (distinct < k) {
        out.println("NO");
        return;
    }
    List<Node> trace = new ArrayList<>(n);
    for (Node node : nodes) {
        topologicalSort(node, trace);
    }
    for (int i = 0; i < trace.size(); i++) {
        trace.get(i).val = Math.min(i, 25);
    }
    out.println("YES");
    for (Node node : nodes) {
        out.append((char) (node.set.val + 'a'));
    }
}