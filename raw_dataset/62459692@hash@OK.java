long hash(String S) {
    long ret = 0;
    for (int i = 0; i < S.length(); ++i) {
        ret += hp.pow(S.charAt(i) * 88, 3, MOD);
        ret += 3 * hp.pow(i + 1, 83, MOD);
        ret %= MOD;
    }
    return ret;
}