public Node findCenter(Node root, Edge p, int total) {
    int maxChild = total - root.size;
    for (Edge e : root.next) {
        if (e == p) {
            continue;
        }
        Node node = e.other(root);
        maxChild = Math.max(maxChild, node.size);
    }
    if (maxChild * 2 <= total) {
        return root;
    }
    for (Edge e : root.next) {
        if (e == p) {
            continue;
        }
        Node node = e.other(root);
        Node ans = findCenter(node, e, total);
        if (ans != null) {
            return ans;
        }
    }
    return null;
}