static long pow(long x, int y, long mod) {
    long ans = 1;
    while (y > 0) {
        if (y % 2 == 0) {
            x *= x;
            x %= mod;
            y /= 2;
        } else {
            y -= 1;
            ans *= x;
            ans %= mod;
        }
    }
    return ans;
}