public void tarjan(Node root) {
    if (root.dfn != 0) {
        return;
    }
    root.dfn = root.low = dfn++;
    root.instk = true;
    deque.addLast(root);
    for (Node node : root.next) {
        tarjan(node);
        if (node.instk && node.low < root.low) {
            root.low = node.low;
        }
    }
    if (root.low == root.dfn) {
        while (true) {
            Node tail = deque.removeLast();
            tail.set = root;
            tail.instk = false;
            if (tail == root) {
                break;
            }
        }
    }
}