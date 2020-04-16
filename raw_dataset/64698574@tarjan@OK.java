void tarjan(Node root, Node father) {
    if (root.dfn != 0) {
        return;
    }
    root.low = root.dfn = dfn++;
    root.instk = true;
    stack.addLast(root);
    for (Node node : root.next) {
        if (node == father) {
            continue;
        }
        tarjan(node, root);
        if (node.instk) {
            root.low = Math.min(root.low, node.low);
        }
    }
    if (root.low == root.dfn) {
        while (true) {
            Node last = stack.removeLast();
            last.set = root;
            last.instk = false;
            if (last == root) {
                break;
            }
            root.w += last.w;
            root.size++;
            root.next = CollectionUtils.mergeHeuristically(root.next, last.next);
        }
    }
}