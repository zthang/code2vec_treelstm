private ArrayList<Integer> factors(int n, boolean include) {
    ArrayList<Integer> factors = new ArrayList<>();
    if (n < 0)
        return factors;
    if (include) {
        factors.add(1);
        if (n > 1)
            factors.add(n);
    }
    int i = 2;
    for (; i * i < n; i++) {
        if (n % i == 0) {
            factors.add(i);
            factors.add(n / i);
        }
    }
    if (i * i == n) {
        factors.add(i);
    }
    return factors;
}