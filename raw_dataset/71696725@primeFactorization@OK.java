private static Map<Long, Long> primeFactorization(long n, long m) {
    Map<Long, Long> map = new HashMap<>();
    for (long i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) {
            long count = 0;
            while (n % i == 0) {
                count++;
                n = n / i;
            }
            long val = count * m;
            map.put(i, val);
        // System.out.println("i: " + i + ", count: " + count);
        }
    }
    if (n != 1) {
        // System.out.println(n);
        map.put(n, m);
    }
    return map;
}