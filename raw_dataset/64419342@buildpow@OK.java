void buildpow(int l, int i) {
    pow = new long[i + 1];
    pow[0] = 1;
    for (int j = 1; j <= i; j++) {
        pow[j] = pow[j - 1] * l;
        if (pow[j] > mod)
            pow[j] %= mod;
    }
}