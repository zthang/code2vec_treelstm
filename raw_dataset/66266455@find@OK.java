Node find(Node nd) {
    Node parent = nd.parent;
    if (parent == nd)
        return parent;
    nd.parent = find(nd.parent);
    return parent;
}