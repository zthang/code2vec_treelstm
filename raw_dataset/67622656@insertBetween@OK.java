static void insertBetween(Node a, Node b, Node c) {
    if (a.next == c) {
        b.next = a.next;
        a.next = b;
        b.prev = c.prev;
        c.prev = b;
    } else {
        b.next = c.next;
        c.next = b;
        b.prev = a.prev;
        a.prev = b;
    }
}