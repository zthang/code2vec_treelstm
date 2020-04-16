static boolean iP(long n) {
    if (n == 2) {
        return true;
    }
    if ((n & 1) == 0 || n == 1) {
        return false;
    }
    // if(n>3037007383L){
    if (n > Integer.MAX_VALUE) {
        return tameshiwari(n);
    }
    long d = n - 1;
    int s = 0;
    while ((d & 1) == 0) {
        d /= 2;
        s++;
    }
    int[] aa = { 2, 3, 5, 7, 11, 13, 17 };
    for (int i = 0; i < 7 && aa[i] < n; i++) {
        int a = aa[i];
        long t = d;
        long y = repow(a, t, n);
        while (t != n - 1 && y != 1 && y != n - 1) {
            y = (y * y) % n;
            t = t << 1;
        }
        if (y != n - 1 && (t & 1) == 0) {
            return false;
        }
    }
    return true;
}