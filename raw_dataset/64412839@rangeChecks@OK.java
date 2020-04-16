protected void rangeChecks(int row, int column) {
    if (row < 0 || column < 0 || row >= getRowCount() || column >= getColumnCount())
        throw new IllegalArgumentException();
}