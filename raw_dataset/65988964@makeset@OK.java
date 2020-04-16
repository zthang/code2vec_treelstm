public void makeset(String data) {
    Node node = new Node();
    node.data = data;
    node.rank = 0;
    node.parent = node;
    map.put(data, node);
}