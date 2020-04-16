private void checkRange(int i) {
    if (i < 0 || i >= size) {
        throw new ArrayIndexOutOfBoundsException();
    }
}