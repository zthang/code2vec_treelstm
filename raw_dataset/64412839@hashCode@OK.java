public int hashCode() {
    return Objects.hash(Utils.hashAll(this.iterator()), this.getRowCount(), this.getColumnCount());
}