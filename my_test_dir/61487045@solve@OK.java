public void solve() {
    int n = io.readInt();
    int m = io.readInt();
    Node[] nodes = new Node[n + 1];
    for (int i = 1; i <= n; i++) {
        nodes[i] = new Node();
    }
    for (int i = 0; i < m; i++) {
        Node a = nodes[io.readInt()];
        Node b = nodes[io.readInt()];
        a.next.add(b);
        b.next.add(a);
    }
    Set<Node> first = new HashSet<>(Arrays.asList(nodes).subList(1, n + 1));
    first.removeAll(nodes[1].next);
    for (Node node : first) {
        node.group = 1;
    }
    if (nodes[1].next.size() == 0) {
        io.cache.append(-1);
        return;
    }
    Node secondHead = nodes[1].next.get(0);
    Set<Node> second = new HashSet<>(n);
    for (int i = 1; i <= n; i++) {
        if (nodes[i].group == 0) {
            second.add(nodes[i]);
        }
    }
    second.removeAll(secondHead.next);
    for (Node node : second) {
        node.group = 2;
    }
    Set<Node> third = new HashSet<>(n);
    for (int i = 1; i <= n; i++) {
        if (nodes[i].group == 0) {
            third.add(nodes[i]);
        }
    }
    for (Node node : third) {
        node.group = 3;
    }
    boolean valid = check(first, n) && check(second, n) && check(third, n);
    if (!valid) {
        io.cache.append(-1);
        return;
    }
    for (int i = 1; i <= n; i++) {
        io.cache.append(nodes[i].group).append(' ');
    }
}