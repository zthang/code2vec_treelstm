/**
 * 增加一条有效期截止到dieTime的边
 */
public void addEdge(int aId, int bId, int dieTime) {
    LCTNode a = nodes[aId];
    LCTNode b = nodes[bId];
    LCTNode.findRoute(a, b);
    LCTNode.splay(a);
    if (a.eldest.dieTime >= dieTime) {
        return;
    }
    LCTNode eldest = a.eldest;
    LCTNode.splay(eldest);
    LCTNode.cut(eldest.a, eldest);
    LCTNode.cut(eldest.b, eldest);
    LCTNode node = new LCTNode();
    node.dieTime = dieTime;
    node.a = a;
    node.b = b;
    node.pushUp();
    LCTNode.join(node.a, node);
    LCTNode.join(node.b, node);
}