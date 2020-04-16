void clear() {
    for (int i = 0; i < data.length; i += 2) {
        data[i] = EMPTY;
    }
    size = 0;
}