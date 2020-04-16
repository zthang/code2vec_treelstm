public static void Preprocess() {
    for (int i = 2; i < MAXK + 1; i++) {
        for (int j = 0; j < MAXK + 1; j++) primeExponential[i][j] += primeExponential[i - 1][j];
        int tmp = i;
        for (int x = 2; x <= Math.sqrt(tmp); x++) {
            while (tmp % x == 0) {
                primeExponential[i][x]++;
                tmp /= x;
            }
        }
        if (tmp > 1)
            primeExponential[i][tmp]++;
    }
}