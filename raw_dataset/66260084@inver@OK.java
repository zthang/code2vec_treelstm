static long inver(long x) {
    int a = (int) x;
    long e = (mod - 2);
    long res = 1;
    while (e > 0) {
        if ((e & 1) == 1) {
            // System.out.println(res*a);
            res = (int) ((1l * res * a) % mod);
        }
        a = (int) ((1l * a * a) % mod);
        e >>= 1;
    }
    // out.println(res+" "+x);
    return res % mod;
}