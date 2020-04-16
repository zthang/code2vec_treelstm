public boolean equals(Object obj) {
    if (!(obj instanceof IntegerList)) {
        return false;
    }
    IntegerList other = (IntegerList) obj;
    return SequenceUtils.equal(data, 0, size - 1, other.data, 0, other.size - 1);
}