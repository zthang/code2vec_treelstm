long gethash(int le, int ri) {
    long res = l.get(ri);
    if (le != 0) {
        res -= l.get(le - 1);
        res += mp.mod;
        res %= mp.mod;
        res *= mp.revpow[le];
        res %= mp.mod;
    }
    return res;
}