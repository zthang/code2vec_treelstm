public static long modAdd(long a, long b, long mod) {
    a = realMod(a, mod);
    b = realMod(b, mod);
    return realMod(a - mod + b, mod);
}