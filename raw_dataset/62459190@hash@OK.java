long hash(String S) {
    long ret = 0;
    for (int i = 0; i < S.length(); ++i) {
        ret += S.charAt(i) * hp.pow(37, i + 3, MOD);
        ret ^= MOD;
    }
    return ret;
}