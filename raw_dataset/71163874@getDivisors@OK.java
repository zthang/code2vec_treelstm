private static Set<Long> getDivisors(long n) {
    Set<Long> divisors = new HashSet<>();
    divisors.add(1L);
    divisors.add(n);
    for (long i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) {
            divisors.add(i);
            divisors.add(n / i);
        }
    }
    return divisors;
}