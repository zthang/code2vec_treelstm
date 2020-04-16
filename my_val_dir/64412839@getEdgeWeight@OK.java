public double getEdgeWeight(int v1, int v2) {
    rangeChecks(v1, v2);
    return matrix.get(v1, v2);
}