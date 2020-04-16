public static int PHV(int l, int r, int n, boolean reverse) {
    if (l > r) {
        return 0;
    }
    int val = (int) ((1l * HashsArray[n - 1][r] + mod - HashsArray[n - 1][l - 1]) % mod);
    if (!reverse) {
        val = (int) ((1l * val * prepow[prelen - l]) % mod);
    } else {
        val = (int) ((1l * val * prepow[r - 1]) % mod);
    }
    return val;
}