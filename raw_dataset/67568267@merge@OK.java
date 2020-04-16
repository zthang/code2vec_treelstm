static void merge(Node a, Node b, Node c) {
    if (a.x == b) {
        a.x = c;
        c.x = b;
    } else {
        b.x = c;
        c.x = a;
    }
}