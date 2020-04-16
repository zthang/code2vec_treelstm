public void topologicalSort(Node root, List<Node> trace) {
    if (root.visited) {
        return;
    }
    root.visited = true;
    for (Node node : root.next) {
        topologicalSort(node, trace);
    }
    if (root.set == root) {
        trace.add(root);
    }
}