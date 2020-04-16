public static long add(long a, long b) {
    return mod(mod(a, MOD) + mod(b, MOD), MOD);
}