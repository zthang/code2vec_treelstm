private SparseVector getRowModifiable(int index) {
    SparseVector result = rows.get(index);
    if (result != emptyRow) {
        return result;
    } else {
        result = new SparseVector(clmnsCount, getSparseValue());
        rows.set(index, result);
        return result;
    }
}