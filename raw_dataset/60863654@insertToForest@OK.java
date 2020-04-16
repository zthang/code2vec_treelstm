private void insertToForest(Node xy, int k) {
    Node[] forest = lvs[k].forest;
    if (forest[xy.from] == null) {
        forest[xy.from] = xy;
        xy.prev = xy.next = null;
        // 再接続する可能性もあるため
        update(xy);
    } else {
        Node z = forest[xy.from];
        Node zn = z.next;
        if (zn != null)
            zn.prev = xy;
        z.next = xy;
        xy.prev = z;
        xy.next = zn;
    }
}