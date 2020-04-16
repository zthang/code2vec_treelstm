static long getpow(long b, long e, long M) {
    if (e == 0)
        return 1;
    else if (e % 2 == 0)
        return getpow((b * b) % M, e / 2, M);
    else
        return (b * getpow(b, e - 1, M)) % M;
}