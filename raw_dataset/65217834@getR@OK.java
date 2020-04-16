int getR(long x) {
    return (int) (x & ((1 << 20) - 1));
}