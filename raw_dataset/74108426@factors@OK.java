static HashSet<Long> factors(long n) {
    HashSet<Long> hs = new HashSet<Long>();
    for (long i = 1; i <= (long) Math.sqrt(n); i++) {
        if (n % i == 0) {
            hs.add(i);
            hs.add(n / i);
        }
    }
    return hs;
}