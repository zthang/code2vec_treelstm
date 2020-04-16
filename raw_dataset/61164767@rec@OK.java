int rec(int edgeId) {
    recs++;
    if (recs % 100000 == 0)
        System.out.println(recs);
    if (edgeId == edges.length) {
        return 0;
    }
    int res = rec(edgeId + 1);
    for (int which = 0; which < 21; which++) {
        if (used[which])
            continue;
        int o1 = dominos[which][0];
        int o2 = dominos[which][1];
        int[] what = { o1, o2 };
        int u = edges[edgeId][0];
        int v = edges[edgeId][1];
        for (int ii = 0; ii < 2; ii++) {
            if (assigned[u] != -1 && assigned[u] != what[ii]) {
                continue;
            }
            if (assigned[v] != -1 && assigned[v] != what[ii ^ 1]) {
                continue;
            }
            int oldu = assigned[u];
            int oldv = assigned[v];
            assigned[u] = what[ii];
            assigned[v] = what[ii ^ 1];
            used[which] = true;
            res = Math.max(res, 1 + rec(edgeId + 1));
            used[which] = false;
            assigned[u] = oldu;
            assigned[v] = oldv;
        }
    }
    return res;
}