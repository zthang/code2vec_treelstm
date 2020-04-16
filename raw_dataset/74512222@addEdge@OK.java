void addEdge(int a, int b) {
    int e = numEdges++;
    if (e >= edgeDst.length) {
        reallocate();
    }
    edgeDst[e] = b;
    edgeNxt[e] = firstEdge[a];
    firstEdge[a] = e;
    ++deg[a];
    ++deg[b];
}