public static long modMul(long a, long b, long mod) {
    a = realMod(a, mod);
    if (a == 0)
        return 0;
    b = realMod(b, mod);
    if (b <= Long.MAX_VALUE / a) {
        return MathUtils.realMod(a * b, mod);
    }
    return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValueExact();
}