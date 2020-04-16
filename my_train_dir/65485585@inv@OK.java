long inv(long a, long MOD) {
    // return fpow(a, MOD-2, MOD);
    return a == 1 ? 1 : (long) (MOD - MOD / a) * inv(MOD % a, MOD) % MOD;
}