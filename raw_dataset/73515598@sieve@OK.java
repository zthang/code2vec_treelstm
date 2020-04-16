private static void sieve() {
    for (int i = 2; i < lim; i++) {
        if (spf[i] == 0) {
            spf[i] = i;
            if ((long) i * i < lim)
                for (int j = i * i; j < lim; j += i) {
                    if (spf[j] == 0)
                        spf[j] = i;
                }
        }
    }
}