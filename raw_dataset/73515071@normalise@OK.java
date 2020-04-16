private static int normalise(int N) {
    int val = 1;
    while (N > 1) {
        int f = spf[N];
        int c = 0;
        while (spf[N] == f) {
            c ^= 1;
            N /= f;
        }
        if (c == 1)
            val *= f;
    }
    return val;
}