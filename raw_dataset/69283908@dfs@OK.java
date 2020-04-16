public void dfs(Node root, Edge p) {
    root.size = root.weight;
    for (Edge e : root.next) {
        if (e == p) {
            continue;
        }
        Node node = e.other(root);
        dfs(node, e);
        root.size += node.size;
    }
}