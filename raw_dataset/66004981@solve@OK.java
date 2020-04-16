public int solve(int lId, int rId) {
    if (lId == rId) {
        return getSingle(lId);
    }
    int a = con[lId], b = con[rId];
    int lca = lca(a, b);
    int pA = beforeLca(a, lca);
    int pB = beforeLca(b, lca);
    int curEs = G[pA][lId] + L[pB][rId];
    curEs += sumExEx(lca, pA, pB);
    if (minCon[pA] == lId && maxCon[pA] <= rId)
        curEs++;
    if (minCon[pB] >= lId && maxCon[pB] == rId)
        curEs++;
    if (minCon[lca] == lId && maxCon[lca] == rId) {
        int cur = lca;
        for (int i = log - 1; i >= 0; i--) {
            int next = lift[cur][i];
            if (minCon[next] == lId && maxCon[next] == rId)
                cur = next;
        }
        curEs += from(lca, cur);
        if (cur != 0)
            curEs++;
    }
    // System.out.println(myTree+" l="+lId+" r="+rId+" curEs= "+curEs);
    return curEs;
}