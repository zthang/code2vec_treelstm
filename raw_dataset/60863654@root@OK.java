private Node root(Node a) {
    if (a == null)
        return null;
    while (a.parent != null) a = a.parent;
    return a;
}