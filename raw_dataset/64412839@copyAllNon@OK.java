protected static void copyAllNon(Matrix from, Matrix to, double value) {
    if (from.getRowCount() > to.getRowCount() || from.getColumnCount() > to.getColumnCount())
        throw new IllegalArgumentException("from matrix too large");
    if (from instanceof SparseMatrix && MathUtils.doubleEquals(((SparseMatrix) from).getSparseValue(), value)) {
        for (Triple<Integer, Integer, Double> t : from) {
            to.set(t.getLeft(), t.getMiddle(), t.getRight());
        }
    } else {
        for (int i = 0; i < from.getRowCount(); i++) {
            for (int j = 0; j < from.getColumnCount(); j++) {
                double g = from.get(i, j);
                if (!MathUtils.doubleEquals(value, g))
                    to.set(i, j, g);
            }
        }
    }
}