void buildrevpow(int l, int i) {
    revpow = new long[i + 1];
    revpow[0] = 1;
    for (int j = 1; j <= i; j++) {
        revpow[j] = revpow[j - 1] * l;
        if (revpow[j] > mod)
            revpow[j] %= mod;
    }
}