private static void sieve() {
    int k = 0;
    for (int i = 2; i < lim; i++) {
        if (pf[i] == 0) {
            pf[i] = i;
            if ((long) i * i < lim)
                for (int j = i * i; j < lim; j += i) {
                    if (pf[j] == 0)
                        pf[j] = i;
                }
        }
    }
}