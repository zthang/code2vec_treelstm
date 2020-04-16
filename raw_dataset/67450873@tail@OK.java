public long tail() {
    checkRange(0);
    return data[size - 1];
}