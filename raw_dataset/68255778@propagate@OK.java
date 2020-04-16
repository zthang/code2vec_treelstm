public static void propagate(Node x) {
    for (; x != null; x = x.parent) update(x);
}