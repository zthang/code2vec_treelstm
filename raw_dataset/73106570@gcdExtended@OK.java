public static long[] gcdExtended(long p, long q) {
    if (q == 0)
        return new long[] { p, 1, 0 };
    long[] vals = gcdExtended(q, p % q);
    long tmp = vals[2];
    vals[2] = vals[1] - (p / q) * vals[2];
    vals[1] = tmp;
    return vals;
}