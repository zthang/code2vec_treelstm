void addLast(Node node) {
    size++;
    if (tail == null) {
        head = tail = node;
        return;
    }
    tail.next = node;
    node.prev = tail;
    tail = node;
}