static long pow(long a, long b, long md) {
    long ans = 1;
    while (b > 0) {
        if (b % 2 == 1)
            ans = (ans * a) % md;
        a = (a * a) % md;
        b = b / 2;
    }
    return ans;
}