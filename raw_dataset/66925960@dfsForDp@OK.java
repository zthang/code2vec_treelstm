public void dfsForDp(Node root, Edge p) {
    for (Edge e : root.next) {
        if (e == p) {
            continue;
        }
        Node node = e.other(root);
        dfsForDp(node, e);
        root.dp += node.dp;
        if (node.size % 2 == 1) {
            root.dp += e.length;
        }
    }
}