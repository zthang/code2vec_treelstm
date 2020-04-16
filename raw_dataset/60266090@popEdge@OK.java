public EdgeChain popEdge() {
    EdgeChain head = chain;
    chain = head.next;
    head.next = null;
    return head;
}