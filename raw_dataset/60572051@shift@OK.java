int shift() {
    if (size == 0) {
        throw new NoSuchElementException();
    }
    int value = data[0];
    arraycopy(data, 1, data, 0, --size);
    return value;
}