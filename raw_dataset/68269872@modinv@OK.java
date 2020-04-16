static long modinv(long x) {
    return modpow(x, mod - 2);
}