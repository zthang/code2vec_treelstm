long pow(long l, long i) {
    if (i == 0)
        return 1;
    else {
        if (i % 2 == 0) {
            long val = pow(l, i / 2);
            return val * val % mod;
        } else
            return pow(l, i - 1) * l % mod;
    }
}