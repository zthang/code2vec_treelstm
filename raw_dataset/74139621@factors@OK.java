public static List<Integer> factors(int n) {
    List<Integer> factors = new ArrayList<>();
    int i = 1;
    for (; i * i < n; i++) {
        if (n % i == 0) {
            factors.add(i);
            factors.add(n / i);
        }
    }
    if (i * i == n)
        factors.add(i);
    return factors;
}