public static void merge(Node a, Node b, Deque<Node> deque) {
    a = a.find();
    b = b.find();
    if (a == b) {
        return;
    }
    if (a.rank > b.rank) {
        Node tmp = a;
        a = b;
        b = tmp;
    }
    a.p = b;
    b.rank += a.rank;
    deque.addLast(a);
}