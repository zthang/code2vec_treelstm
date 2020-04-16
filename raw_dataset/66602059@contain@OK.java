boolean contain(int mask, int bit) {
    return ((two(bit) & mask) > 0);
}