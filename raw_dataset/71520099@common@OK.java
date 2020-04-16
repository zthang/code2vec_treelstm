private int common(int v) {
    int c = 0;
    while (v != 1) {
        v = (v >>> 1);
        ++c;
    }
    return c;
}