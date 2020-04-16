public void dfsForSize(Node root, Edge p) {
    root.size = 1;
    root.depth = p == null ? 0 : p.other(root).depth + p.length;
    for (Edge e : root.next) {
        if (e == p) {
            continue;
        }
        Node node = e.other(root);
        dfsForSize(node, e);
        root.size += node.size;
        if (root.heavy == null || root.heavy.other(root).size < node.size) {
            root.heavy = e;
        }
    }
}