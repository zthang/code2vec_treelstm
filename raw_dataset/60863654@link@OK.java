private Node link(int x, int y, int level, NodeInfo info) {
    gctLink++;
    Node tsx = reroot(x, level);
    Node tsy = reroot(y, level);
    Node xy = new Node(x, y, info, lvs[level]);
    Node yx = new Node(y, x, info, lvs[level]);
    xy.reverse = yx;
    yx.reverse = xy;
    insertToForest(xy, level);
    insertToForest(yx, level);
    tsx = insert(tsx, count(tsx), xy);
    tsy = insert(tsy, count(tsy), yx);
    merge(tsx, tsy);
    // merge(tsx, xy, tsy, yx);
    return xy;
}