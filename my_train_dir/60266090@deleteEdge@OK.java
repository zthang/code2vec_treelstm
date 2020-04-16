public void deleteEdge(int i, int j) {
    long idOfEdge = idOfEdge(i, j);
    EdgeInfo info = map.remove(idOfEdge);
    if (info.level == 0) {
        return;
    }
    int curLevel = info.level;
    info.level = -1;
    if (!levels[log2].map.containsKey(idOfEdge)) {
        return;
    }
    for (int k = curLevel; k <= log2; k++) {
        levels[k].cut(i, j);
    }
    for (int k = curLevel; k <= log2; k++) {
        Splay ti = levels[k].nodes[i];
        Splay tj = levels[k].nodes[j];
        Splay.splay(ti);
        Splay.splay(tj);
        if (ti.size > tj.size) {
            Splay tmp = ti;
            ti = tj;
            tj = tmp;
        }
        Splay.splay(ti);
        while (ti.infoWithMaxLevel != null) {
            ti = ti.infoWithMaxLevel;
            Splay.splay(ti);
            if (ti.infoWithMaxLevel.info.level < k) {
                break;
            }
            pushDownEdge(ti.info, true);
            Splay.splay(ti);
        }
        Splay.splay(ti);
        while (ti.containEdge != null) {
            ti = ti.containEdge;
            Splay.splay(ti);
            EdgeInfo e = ti.popEdge().info;
            ti.pushUp();
            if (e.level < k) {
            } else if (levels[log2].rootOf(e.a) == levels[log2].rootOf(e.b)) {
                if (e.level == k) {
                    pushDownEdge(e, false);
                }
            } else {
                addEdgeChain(e);
                for (int t = k; t <= log2; t++) {
                    levels[t].link(e);
                }
                return;
            }
            Splay.splay(ti);
        }
    }
}