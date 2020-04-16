public boolean check(int[] f, int[] s) {
    for (int i = 0; i < 26; i++) {
        if (f[i] == s[i]) {
            return true;
        }
    }
    return false;
}