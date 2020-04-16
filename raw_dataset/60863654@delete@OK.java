public boolean delete(int x, int y) {
    if (x == y)
        return false;
    if (x > y) {
        int d = x;
        x = y;
        y = d;
    }
    NodeInfo info = (NodeInfo) bank[x].get(y);
    if (info == null) {
        // not exist
        throw new RuntimeException();
    }
    if (!info.isTreeNode) {
        // delete auxiliary edge
        info.dup--;
        if (info.dup == 0) {
            bank[x].remove(y);
            removeFromAuxis(info);
        }
        return false;
    }
    // delete tree edge
    info.dup--;
    if (info.dup == 0) {
        Node xy = ((NodeInfo) bank[x].get(y)).zero;
        bank[x].remove(y);
        for (int k = 0; k <= info.level; k++) {
            // remove tree edge from all level
            Node up = xy.up;
            Node yx = xy.reverse;
            // timeval -= System.nanoTime();
            int ixy = index(xy);
            int iyx = index(yx);
            // timeval += System.nanoTime();
            if (ixy < iyx) {
                Node[] abc_e = splitEx(yx);
                Node[] a_c = splitEx(xy);
                lts[k][0] = merge(abc_e[1], a_c[0]);
                lts[k][1] = a_c[1];
            } else {
                Node[] abc_e = splitEx(xy);
                Node[] a_c = splitEx(yx);
                lts[k][1] = merge(abc_e[1], a_c[0]);
                lts[k][0] = a_c[1];
            }
            removeFromForest(xy, k);
            removeFromForest(yx, k);
            xy = up;
        }
        if (lvs[info.level + 1] == null)
            lvs[info.level + 1] = new Level(bank.length);
        for (int k = info.level; k >= 0; k--) {
            Node target = count(lts[k][0]) < count(lts[k][1]) ? lts[k][0] : lts[k][1];
            // 30%
            updateTreeEdgesLevelNoRec(target, k);
            // for(int z = 0;z < 20;z++){
            // if(sample(target, k))break inner;
            // }
            int cp = -1;
            if (target != null) {
                cp = collect(target, 0);
            } else {
                collected[0] = count(lts[k][0]) == 0 ? x : y;
                cp = 1;
            }
            Arrays.sort(collected, 0, cp);
            for (int u = 0; u < cp; u++) {
                int from = collected[u];
                for (AuxiliaryEdge aux = lvs[k].auxis[from]; aux != null; ) {
                    int to = aux.to;
                    AuxiliaryEdge next = aux.next;
                    if (Arrays.binarySearch(collected, 0, cp, to) >= 0) {
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
                        return false;
                    }
                    aux = next;
                }
            // updateForest(k, from);
            }
        }
        return true;
    }
    return false;
}