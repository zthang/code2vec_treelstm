long gcd(long a, long b) {
    a = Math.abs(a);
    b = Math.abs(b);
    if (a == 0)
        return b;
    if (b == 0)
        return a;
    if (a % b == 0)
        return b;
    else
        return gcd(b, a % b);
}