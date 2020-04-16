public void solve(int testNumber, FastInput in, FastOutput out) {
    int n = in.readInt();
    int m = in.readInt();
    Node[] nodes = new Node[n + 1];
    for (int i = 1; i <= n; i++) {
        nodes[i] = new Node();
        nodes[i].id = i;
    }
    for (int i = 0; i < m; i++) {
        Node a = nodes[in.readInt()];
        Node b = nodes[in.readInt()];
        a.set.add(b);
        b.set.add(a);
    }
    LinkedList wait = new LinkedList();
    LinkedList pend = new LinkedList();
    for (int i = 1; i <= n; i++) {
        wait.addLast(nodes[i]);
    }
    pend.addLast(wait.remove(wait.head));
    int fee = 0;
    while (wait.head != null) {
        if (pend.head == null) {
            fee++;
            pend.addLast(wait.remove(wait.head));
            continue;
        }
        Node head = pend.remove(pend.head);
        for (Node node = wait.head, next; node != null; node = next) {
            next = node.next;
            if (head.set.contains(node)) {
                continue;
            }
            pend.addLast(wait.remove(node));
        }
    }
    out.println(fee);
}