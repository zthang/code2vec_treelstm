public void solve(int testNumber, FastInput in, FastOutput out) {
    int n = in.readInt();
    int m = in.readInt();
    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) {
        nodes[i] = new Node();
        nodes[i].id = i;
    }
    for (int i = 0; i < m; i++) {
        Node a = nodes[in.readInt() - 1];
        Node b = nodes[in.readInt() - 1];
        a.next.add(b);
        b.next.add(a);
    }
    for (Node node : nodes) {
        node.deg = node.next.size();
    }
    req = (int) Math.ceil(Math.sqrt(n));
    List<Node> independentSet = new ArrayList<>();
    TreeSet<Node> set = new TreeSet<>((a, b) -> a.deg == b.deg ? a.id - b.id : Integer.compare(a.deg, b.deg));
    set.addAll(Arrays.asList(nodes));
    while (!set.isEmpty() && set.first().deg < req - 1) {
        Node head = set.pollFirst();
        independentSet.add(head);
        head.removed = true;
        for (Node e : head.next) {
            if (e.removed) {
                continue;
            }
            e.removed = true;
            set.remove(e);
            for (Node node : e.next) {
                if (node.removed) {
                    continue;
                }
                set.remove(node);
                node.deg--;
                set.add(node);
            }
        }
    }
    if (set.isEmpty()) {
        out.println(1);
        for (int i = 0; i < independentSet.size() && i < req; i++) {
            out.append(independentSet.get(i).id + 1).append(' ');
        }
        return;
    }
    for (Node node : nodes) {
        if (dfs(node, null, 0)) {
            break;
        }
    }
    out.println(2);
    out.println(dq.size());
    for (Node node : dq) {
        out.append(node.id + 1).append(' ');
    }
}