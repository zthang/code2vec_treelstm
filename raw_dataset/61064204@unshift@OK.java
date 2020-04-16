void unshift(int value) {
    expand();
    arraycopy(data, 0, data, 1, size++);
    data[0] = value;
}