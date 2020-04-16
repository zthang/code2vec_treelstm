public VectorElementIterator getFilteredRowElements(int row, DoublePredicate filter) {
    return matrix.getFilteredColumnElements(row, filter);
}