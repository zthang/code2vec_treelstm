long pow(long b, long e, long m) {
    if (e == 0)
        return 1;
    long r = pow(b, e / 2, m);
    if ((e & 1) == 0)
        return r * r % m;
    return (r * r % m) * b % m;
}