boolean robin_miller(long x) {
    if (x == 1)
        return false;
    if (x == 2)
        return true;
    if (x == 3)
        return true;
    if ((x & 1) == 0)
        return false;
    long y = x % 6;
    if (y == 1 || y == 5) {
        long ck = x - 1;
        while ((ck & 1) == 0) ck >>>= 1;
        long[] as = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37 };
        for (int i = 0; i < as.length; ++i) {
            long a = as[i];
            long ck1 = ck;
            a = mod_pow(a, ck1, x);
            while (ck1 < x) {
                y = mod_pow(a, 2, x);
                if (y == 1 && a != 1 && a != x - 1)
                    return false;
                a = y;
                ck1 = ck1 << 1;
            }
            if (a != 1)
                return false;
        }
        return true;
    } else {
        return false;
    }
}