public static void Solve() {
    Preprocess();
    int[] bestPD = new int[MAXK + 1];
    for (int i = 0; i < MAXK + 1; i++) bestPD[i] = 1;
    long ans = 0, cur = 0;
    for (int i = 1; i < MAXK + 1; i++) {
        if (cnt[i] == 0) {
            bestPD[i] = 1;
            continue;
        }
        for (int j = 1; j < MAXK + 1; j++) {
            ans += (long) primeExponential[i][j] * cnt[i];
            cur += (long) primeExponential[i][j] * cnt[i];
            if (primeExponential[i][j] != 0)
                bestPD[i] = j;
        }
    }
    while (max_element(bestPD) > 1) {
        int[] frequency = new int[MAXK + 1];
        for (int i = 0; i < MAXK + 1; i++) frequency[bestPD[i]] += cnt[i];
        int bestPrime = max_id(frequency);
        int bestGroup = frequency[bestPrime];
        if (bestGroup * 2 <= n)
            break;
        if (bestPrime == 1)
            break;
        cur -= bestGroup;
        cur += (n - bestGroup);
        ans = min(ans, cur);
        for (int i = 0; i < MAXK + 1; i++) {
            if (bestPD[i] != bestPrime)
                bestPD[i] = 1;
            if (bestPD[i] == 1)
                continue;
            primeExponential[i][bestPD[i]] -= 1;
            while (bestPD[i] > 1 && primeExponential[i][bestPD[i]] == 0) bestPD[i]--;
        }
    }
    out.println(ans);
}