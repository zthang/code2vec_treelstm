int mult(long a, long b) {
    a *= b;
    if (a >= MOD)
        a %= MOD;
    return (int) a;
}