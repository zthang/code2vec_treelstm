long hash(String S) {
    long ret = 0;
    for (int i = 0; i < S.length(); ++i) {
        ret += S.charAt(i) * pow[i + 3];
        ret ^= MOD;
    }
    return ret;
}