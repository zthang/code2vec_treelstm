static int modPow(int a, int e) {
    int res = 1;
    while (e > 0) {
        if ((e & 1) == 1)
            res = (res * a);
        a = (a * a);
        e >>= 1;
    }
    return res;
}