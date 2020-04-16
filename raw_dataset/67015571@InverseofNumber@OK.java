public static void InverseofNumber(long p) {
    naturalNumInverse = new long[N + 1];
    naturalNumInverse[0] = 1;
    naturalNumInverse[1] = 1;
    for (int i = 2; i <= N; i++) {
        naturalNumInverse[i] = naturalNumInverse[(int) (p % i)] * (p - p / i) % p;
    }
}