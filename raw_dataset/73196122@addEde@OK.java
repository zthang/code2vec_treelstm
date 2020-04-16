private void addEde(int x, int y) {
    nodes.get(x).addChild(nodes.get(y));
    nodes.get(y).addChild(nodes.get(x));
}