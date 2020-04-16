static long pow(long in, long pow) {
    if (pow == 0)
        return 1;
    long out = pow(in, pow / 2);
    out = (out * out) % mod;
    if (pow % 2 == 1)
        out = (out * in) % mod;
    return out;
}