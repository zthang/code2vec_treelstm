private void addEdge(int a, int b) {
    int e = numEdges++;
    edgeNxt[e] = firstEdge[a];
    edgeDst[e] = b;
    firstEdge[a] = e;
}