private Node first(Node a) {
    if (a == null)
        return null;
    while (a.left != null) a = a.left;
    return a;
}