public int hashCode() {
    int h = 1;
    for (int i = 0; i < size; i++) {
        h = h * 31 + Integer.hashCode(data[i]);
    }
    return h;
}