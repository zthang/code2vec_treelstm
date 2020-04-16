public VectorElementIterator getNeighbours(int vertex) {
    return this.matrix.getRowNonValued(vertex, Double.NaN);
}