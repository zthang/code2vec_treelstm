public static void InverseofFactorial(long p) {
    factorialNumInverse = new long[N + 1];
    factorialNumInverse[0] = 1;
    factorialNumInverse[1] = 1;
    for (int i = 2; i <= N; i++) {
        factorialNumInverse[i] = (naturalNumInverse[i] * factorialNumInverse[i - 1]) % p;
    }
}