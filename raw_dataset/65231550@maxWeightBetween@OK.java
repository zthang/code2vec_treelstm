public long maxWeightBetween(int aId, int bId) {
    DynamicMST.LCTNode a = nodes[aId];
    DynamicMST.LCTNode b = nodes[bId];
    DynamicMST.LCTNode.findRoute(a, b);
    DynamicMST.LCTNode.splay(b);
    return b.largest.weight;
}