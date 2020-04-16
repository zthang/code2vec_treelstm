private void pushDownEdge(EdgeInfo info, boolean link) {
    info.level--;
    if (info.level == 0) {
        return;
    }
    addEdgeChain(info);
    if (link) {
        levels[info.level].link(info);
    }
}