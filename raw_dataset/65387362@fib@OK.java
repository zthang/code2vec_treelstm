static int fib(int n) {
    double p = (1 + Math.sqrt(5)) / 2;
    return (int) Math.round(Math.pow(p, n) / Math.sqrt(5));
}