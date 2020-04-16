private void addEdgeChain(EdgeInfo info) {
    EdgeChain chain1 = new EdgeChain(info);
    EdgeChain chain2 = new EdgeChain(info);
    Splay.splay(levels[info.level].nodes[info.a]);
    levels[info.level].nodes[info.a].addEdge(chain1);
    levels[info.level].nodes[info.a].pushUp();
    Splay.splay(levels[info.level].nodes[info.b]);
    levels[info.level].nodes[info.b].addEdge(chain2);
    levels[info.level].nodes[info.b].pushUp();
}