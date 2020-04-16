public String toString() {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < getRowCount(); i++) {
        if (i != 0)
            result.append("\n");
        for (int j = 0; j < getColumnCount(); j++) {
            if (j != 0)
                result.append(", ");
            result.append(this.get(i, j));
        }
    }
    return result.toString();
}