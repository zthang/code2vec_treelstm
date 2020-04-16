private void addEdge(int a, int b) {
    int e = numEdges++;
    if (e >= edgeDst.length) {
        int k = edgeDst.length;
        edgeDst = Arrays.copyOf(edgeDst, k * 3 / 2 + 1);
        edgeNxt = Arrays.copyOf(edgeNxt, k * 3 / 2 + 1);
    }
    edgeDst[e] = b;
    edgeNxt[e] = firstEdge[a];
    firstEdge[a] = e;
}