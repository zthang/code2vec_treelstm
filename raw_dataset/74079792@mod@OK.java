public static int mod(int x, int mod) {
    x %= mod;
    if (x < 0) {
        x += mod;
    }
    return x;
}