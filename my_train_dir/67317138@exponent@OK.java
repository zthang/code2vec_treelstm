public long exponent(long a, long b) {
    if (b == 0)
        return 1;
    else {
        long x = exponent(a, b / 2);
        x *= x;
        if (b % 2 == 1)
            x *= a;
        return x;
    }
}