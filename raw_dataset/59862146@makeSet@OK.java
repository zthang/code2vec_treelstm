public void makeSet(long data) {
    Node node = new Node();
    node.data = data;
    node.parent = node;
    node.rank = 1;
    node.size = 1;
    map.put(data, node);
}