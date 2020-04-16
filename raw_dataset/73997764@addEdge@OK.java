static void addEdge(Node x, Node y) {
    x.degree++;
    y.degree++;
    x.children.add(y);
    y.children.add(x);
}