public void addEdge(int aId, int bId, long weight) {
    DynamicMST.LCTNode a = nodes[aId];
    DynamicMST.LCTNode b = nodes[bId];
    DynamicMST.LCTNode.findRoute(a, b);
    DynamicMST.LCTNode.splay(a);
    if (a.largest.weight <= weight) {
        return;
    }
    DynamicMST.LCTNode largest = a.largest;
    DynamicMST.LCTNode.splay(largest);
    DynamicMST.LCTNode.cut(largest.a, largest);
    DynamicMST.LCTNode.cut(largest.b, largest);
    if (largest.weight < Long.MAX_VALUE) {
        edgeNum--;
        totalWeight -= largest.weight;
    }
    DynamicMST.LCTNode node = new DynamicMST.LCTNode();
    node.weight = weight;
    node.a = a;
    node.b = b;
    node.pushUp();
    DynamicMST.LCTNode.join(node.a, node);
    DynamicMST.LCTNode.join(node.b, node);
    edgeNum++;
    totalWeight += node.weight;
}