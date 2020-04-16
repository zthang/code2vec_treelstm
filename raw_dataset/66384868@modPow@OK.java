static double modPow(double a, int e) {
    double res = 1;
    while (e > 0) {
        if ((e & 1) == 1)
            res = (res * a);
        a = (a * a);
        e >>= 1;
    }
    return res;
}