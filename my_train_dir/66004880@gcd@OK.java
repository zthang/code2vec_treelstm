long gcd(long a, long b) {
    if (a == 0)
        return Math.abs(b);
    if (b == 0)
        return Math.abs(a);
    a = Math.abs(a);
    b = Math.abs(b);
    int az = Long.numberOfTrailingZeros(a), bz = Long.numberOfTrailingZeros(b);
    a >>>= az;
    b >>>= bz;
    while (a != b) {
        if (a > b) {
            a -= b;
            a >>>= Long.numberOfTrailingZeros(a);
        } else {
            b -= a;
            b >>>= Long.numberOfTrailingZeros(b);
        }
    }
    return (a << Math.min(az, bz));
}