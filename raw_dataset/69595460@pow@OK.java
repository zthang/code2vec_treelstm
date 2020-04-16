private static long pow(int base, int pow) {
    long val = 1L;
    for (int i = 1; i <= pow; i++) {
        val *= base;
    }
    return val;
}