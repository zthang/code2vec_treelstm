public static int powerMod(long b, long e) {
    long ans = 1;
    while (e-- > 0) {
        ans = ans * b % div;
    }
    return (int) ans;
}