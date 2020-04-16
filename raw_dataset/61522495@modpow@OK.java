static long modpow(long b, long e, long m) {
    long result = 1;
    while (e > 0) {
        if ((e & 1) == 1) {
            /* multiply in this bit's contribution while using modulus to keep
                     * result small */
            result = (result * b) % m;
        }
        b = (b * b) % m;
        e >>= 1;
    }
    return result;
}