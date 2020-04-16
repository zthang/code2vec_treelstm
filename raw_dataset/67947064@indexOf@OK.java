public int indexOf(int x) {
    for (int i = 0; i < size; i++) {
        if (x == data[i]) {
            return i;
        }
    }
    return -1;
}