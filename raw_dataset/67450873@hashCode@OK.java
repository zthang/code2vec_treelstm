public int hashCode() {
    int h = 1;
    for (int i = 0; i < size; i++) {
        h = h * 31 + Long.hashCode(data[i]);
    }
    return h;
}