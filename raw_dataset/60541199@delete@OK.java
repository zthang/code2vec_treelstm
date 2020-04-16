int delete(int index) {
    if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException();
    }
    int value = data[index];
    arraycopy(data, index + 1, data, index, --size - index);
    return value;
}