public boolean union(int x, int y) {
    if (x == y)
        return false;
    if (x > y) {
        int d = x;
        x = y;
        y = d;
    }
    NodeInfo info = (NodeInfo) bank[x].get(y);
    if (info != null) {
        info.dup++;
        return false;
    } else if (areConnected(x, y)) {
        // new auxiliary edge
        info = new NodeInfo(x, y, 1, 0, false);
        info.ft = new AuxiliaryEdge(y);
        info.tf = new AuxiliaryEdge(x);
        bank[x].put(y, info);
        insertToAuxis(info);
        return false;
    } else {
        // new tree edge
        info = new NodeInfo(x, y, 1, 0, true);
        bank[x].put(y, info);
        info.zero = link(x, y, 0, info);
        return true;
    }
}