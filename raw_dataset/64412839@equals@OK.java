public boolean equals(Object obj) {
    if (obj == null)
        return false;
    if (!(obj instanceof Matrix))
        return false;
    Matrix other = (Matrix) obj;
    if (this.getColumnCount() != other.getColumnCount())
        return false;
    if (this.getRowCount() != other.getRowCount())
        return false;
    Matrix o1 = this;
    Matrix o2 = other;
    if (o2 instanceof SparseMatrix) {
        Matrix o3 = o1;
        o1 = o2;
        o2 = o3;
    }
    for (int it = 0; it < 2; it++) {
        if (o1 instanceof DenseMatrix) {
            for (int i = 0; i < o1.getRowCount(); i++) {
                for (int j = 0; j < o1.getColumnCount(); j++) {
                    if (o1.get(i, j) != o2.get(i, j))
                        return false;
                }
            }
            return true;
        }
        for (Triple<Integer, Integer, Double> next : o1) {
            if (o2.get(next.a, next.b) != next.c)
                return false;
        }
        Matrix o3 = o1;
        o1 = o2;
        o2 = o3;
    }
    return true;
}