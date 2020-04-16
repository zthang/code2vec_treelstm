public Node findParentNode(Node node) {
    if (node.parent == node)
        return node;
    node.parent = findParentNode(node.parent);
    return node.parent;
}