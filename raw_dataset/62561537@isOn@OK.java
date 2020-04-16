static boolean isOn(int bit, int mask) {
    return ((1 << bit) & mask) != 0;
}