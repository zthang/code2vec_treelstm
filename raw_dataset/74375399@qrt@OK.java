static long qrt(double d) {
    long k = (long) (d);
    double x = -1 + Math.sqrt(1 + (8 * d));
    x = x / 2;
    long w = (long) (Math.ceil(x));
    long sum = w * (w + 1);
    sum = sum / 2;
    // System.out.println (w+"GDSGDS");
    while (sum % 2 != k % 2) {
        w++;
        sum = w * (w + 1);
        sum = sum / 2;
    }
    return (w);
}