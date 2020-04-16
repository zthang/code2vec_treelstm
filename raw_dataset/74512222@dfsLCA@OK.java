private void dfsLCA(int v) {
    timeIn[v] = globalTime++;
    treeId[v] = numTrees;
    for (int e = g.firstEdge[v]; e >= 0; e = g.edgeNxt[e]) {
        int u = g.edgeDst[e];
        if (u != ancestor[0][v]) {
            ancestor[0][u] = v;
            depth[u] = depth[v] + 1;
            parentEdge[u] = e / 2;
            dfsLCA(u);
        }
    }
    timeOut[v] = globalTime++;
}