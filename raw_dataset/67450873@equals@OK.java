public boolean equals(Object obj) {
    if (!(obj instanceof LongList)) {
        return false;
    }
    LongList other = (LongList) obj;
    return SequenceUtils.equal(data, 0, size - 1, other.data, 0, other.size - 1);
}