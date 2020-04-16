public int setBit(int x, int i, boolean v) {
    if (v) {
        x |= 1 << i;
    } else {
        x &= ~(1 << i);
    }
    return x;
}