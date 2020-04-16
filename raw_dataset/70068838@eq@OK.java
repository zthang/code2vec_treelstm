public static boolean eq(double a, double b) {
    double diff = a - b;
    if (diff < 0)
        diff = -diff;
    if (diff < EPS)
        return true;
    if (a < 0)
        a = -a;
    if (b < 0)
        b = -b;
    if (a < b)
        a = b;
    return (diff < EPS * a);
}