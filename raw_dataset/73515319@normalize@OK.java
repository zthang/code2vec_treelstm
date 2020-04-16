private static int normalize(int N) {
    int val = 1;
    while (N > 1) {
        int tmp = pf[N];
        int c = 0;
        while (pf[N] == tmp) {
            c ^= 1;
            N /= tmp;
        }
        if (c == 1)
            val *= tmp;
    }
    return val;
}