Node remove(Node node) {
    if (node.prev != null) {
        node.prev.next = node.next;
    }
    if (node.next != null) {
        node.next.prev = node.prev;
    }
    if (node == head) {
        head = node.next;
    }
    if (node == tail) {
        tail = node.prev;
    }
    size--;
    node.next = node.prev = null;
    return node;
}