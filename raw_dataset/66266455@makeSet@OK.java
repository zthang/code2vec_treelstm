public void makeSet(String s) {
    Node node = new Node();
    node.s = s;
    node.b = false;
    node.parent = node;
    node.rank = 0;
    mp.put(s, node);
}