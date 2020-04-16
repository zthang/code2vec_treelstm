void set(int index, int value) {
    if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException();
    }
    data[index] = value;
}