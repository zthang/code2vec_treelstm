private Node findSet(Node node) {
    Node parent = node.parent;
    if (parent == node) {
        return parent;
    }
    node.parent = findSet(node.parent);
    return node.parent;
}