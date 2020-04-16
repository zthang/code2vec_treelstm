// Fast exponentiation (x^y mod m)
public static long power(long x, long y, long m) {
    long ans = 1;
    x %= m;
    while (y > 0) {
        if (y % 2 == 1)
            ans = (ans * x) % m;
        y /= 2;
        x = (x * x) % m;
    }
    return ans;
}