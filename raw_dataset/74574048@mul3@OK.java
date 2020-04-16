public long mul3(long a, long b, long c) {
    long i = 1;
    i = mul2(a, i);
    i = mul2(b, i);
    i = mul2(c, i);
    return i;
}