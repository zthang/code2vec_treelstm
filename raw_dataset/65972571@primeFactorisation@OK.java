public ArrayList<Long> primeFactorisation(long n) {
    ArrayList<Long> f = new ArrayList<>();
    for (long x = 2; x * x <= n; x++) {
        while (n % x == 0) {
            f.add(x);
            n /= x;
        }
    }
    if (n > 1)
        f.add(n);
    return f;
}