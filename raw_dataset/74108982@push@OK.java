public void push(Object item) {
    Node node = new Node();
    node.data = item;
    node.next = top;
    top = node;
    Size++;
}