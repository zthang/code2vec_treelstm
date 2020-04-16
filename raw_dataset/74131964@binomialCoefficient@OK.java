private static long binomialCoefficient(long[] factorial, long n, long k, long mod) {
    return factorial[(int) n] * modInv_EEA(factorial[(int) k], mod) % mod * modInv_EEA(factorial[(int) (n - k)], mod) % mod;
}