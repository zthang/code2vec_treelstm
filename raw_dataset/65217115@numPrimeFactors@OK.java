public static int[] numPrimeFactors(int LIM) {
    int i, count = 0;
    int[] b = new int[LIM];
    for (i = 2; i < LIM; ++i) if (b[i] == 0) {
        count++;
        for (int j = i; j < LIM; j += i) b[j]++;
    }
    return b;
}