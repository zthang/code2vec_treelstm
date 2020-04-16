private void initGraph(int n, int m) {
    firstEdge = new int[n];
    Arrays.fill(firstEdge, -1);
    edgeNxt = new int[2 * m];
    edgeDst = new int[2 * m];
    numEdges = 0;
}