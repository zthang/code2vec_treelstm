public VectorElementIterator getFilteredColumnElements(int column, DoublePredicate filter) {
    return matrix.getFilteredRowElements(column, filter);
}