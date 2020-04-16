public long modexp(long a, long b, long c) {
    if (b == 0)
        return 1;
    else {
        long x = modexp(a, b / 2, c);
        x = ((x % c) * (x % c)) % c;
        if (b % 2 == 1)
            x = ((x % c) * (a % c)) % c;
        return x;
    }
}