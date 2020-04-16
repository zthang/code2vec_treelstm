static void delete(Node x, Node y) {
    x.children.remove(y);
    y.children.remove(x);
    x.degree--;
    y.degree--;
}