/**
 * 检查两个顶点之间是否存在一条路径
 */
public boolean check(int aId, int bId) {
    LCTNode a = nodes[aId];
    LCTNode b = nodes[bId];
    LCTNode.findRoute(a, b);
    LCTNode.splay(b);
    return b.eldest.dieTime > time;
}