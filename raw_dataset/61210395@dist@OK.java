public static double dist(long a, long b, long x, long y) {
    double val = (b - a) * (b - a) + (x - y) * (x - y);
    val = Math.sqrt(val);
    double other = x * x + a * a;
    other = Math.sqrt(other);
    return val + other;
}