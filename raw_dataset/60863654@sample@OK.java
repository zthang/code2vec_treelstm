private boolean sample(Node cur, int k) {
    if (cur == null || cur.desaux == 0)
        return false;
    int val = gen.nextInt(cur.desaux);
    int ld = cur.left != null ? cur.left.desaux : 0;
    if (val < ld) {
        boolean ret = sample(cur.left, k);
        update(cur);
        return ret;
    }
    val -= ld;
    int rd = cur.right != null ? cur.right.desaux : 0;
    if (val < rd) {
        boolean ret = sample(cur.right, k);
        update(cur);
        return ret;
    }
    val -= rd;
    // edge sample
    int from = cur.from;
    for (AuxiliaryEdge aux = lvs[k].auxis[from]; aux != null; ) {
        int to = aux.to;
        AuxiliaryEdge next = aux.next;
        if (areConnected(from, to)) {
            // level up
            NodeInfo linfo = (NodeInfo) bank[Math.min(from, to)].get(Math.max(from, to));
            removeFromAuxis(linfo);
            linfo.level++;
            insertToAuxis(linfo);
        } else {
            // promote
            int f = Math.min(from, to), t = Math.max(from, to);
            NodeInfo linfo = (NodeInfo) bank[f].get(t);
            linfo.isTreeNode = true;
            removeFromAuxis(linfo);
            Node prev = null;
            for (int l = 0; l <= k; l++) {
                Node z = link(f, t, l, linfo);
                if (l == 0) {
                    linfo.zero = z;
                } else {
                    prev.up = z;
                    prev.reverse.up = prev.up.reverse;
                }
                prev = z;
            }
            return true;
        }
        aux = next;
    }
    // updateForest(k, from);
    update(cur);
    return false;
}