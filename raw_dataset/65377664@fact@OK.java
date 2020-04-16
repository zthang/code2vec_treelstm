public static long fact(long num) {
    long value = 1;
    long i = 1;
    for (i = 2; i <= num; i++) {
        value = ((value) * (long) i);
    }
    return value;
}