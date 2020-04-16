public boolean dfs(Node root, Node p, int depth) {
    if (root.depth != -1) {
        if (depth - root.depth >= req) {
            while (dq.peekFirst() != root) {
                dq.removeFirst();
            }
            return true;
        }
        return false;
    }
    root.depth = depth;
    dq.addLast(root);
    for (Node node : root.next) {
        if (node.removed || node == p) {
            continue;
        }
        if (dfs(node, root, depth + 1)) {
            return true;
        }
    }
    dq.removeLast();
    return false;
}