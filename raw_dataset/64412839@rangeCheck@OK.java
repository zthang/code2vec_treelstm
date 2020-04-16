private void rangeCheck(int index) {
    if (index < 0 || index >= length)
        throw new IllegalArgumentException("Index out of range: " + index);
}