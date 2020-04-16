private static long modInv_EEA(long a, long mod) {
    long[] res = solveGcdEquation(a, mod);
    if (res[2] != 1) {
        // a and m are not coprime, modular inverse of a by m does not exist.
        return -1;
    }
    return (res[0] % mod + mod) % mod;
}