public void setEdgeWeight(int v1, int v2, double weight) {
    rangeChecks(v1, v2);
    double d = weight;
    int weightZ = Double.isNaN(d) ? 0 : 1;
    int prevWeightZ = Double.isNaN(this.matrix.set(v1, v2, d)) ? 0 : 1;
    int change = weightZ - prevWeightZ;
    edges += change;
    if (!directed) {
        this.matrix.set(v2, v1, d);
    }
    inDegrees.set(v2, inDegrees.get(v2) + change);
    if (directed) {
        outDegrees.set(v1, outDegrees.get(v1) + change);
    } else {
        inDegrees.set(v1, inDegrees.get(v1) + change);
    }
}