private int nBit1(int v) {
    int v0 = v;
    int c = 0;
    while (v != 0) {
        ++c;
        v = v & (v - 1);
    }
    return c;
}