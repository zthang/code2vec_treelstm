public static long fact(long num) {
    long value = 1;
    int i = 0;
    for (i = 2; i < num; i++) {
        value = ((value % mod) * i % mod) % mod;
    }
    return value;
}