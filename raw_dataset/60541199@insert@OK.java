void insert(int index, int value) {
    if (index < 0 || index > size) {
        throw new IndexOutOfBoundsException();
    }
    expand();
    arraycopy(data, index, data, index + 1, size++ - index);
    data[index] = value;
}