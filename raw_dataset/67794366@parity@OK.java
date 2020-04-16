static int parity(int a) {
    a ^= a >> 16;
    a ^= a >> 8;
    a ^= a >> 4;
    a ^= a >> 2;
    a ^= a >> 1;
    return a & 1;
}