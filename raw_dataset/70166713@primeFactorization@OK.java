private static Map<Integer, Integer> primeFactorization(long n) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) {
            int count = 0;
            while (n % i == 0) {
                count++;
                n = n / i;
            }
            map.put(i, count);
        // System.out.println("i: " + i + ", count: " + count);
        }
    }
    if (n != 1) {
        // System.out.println(n);
        map.put((int) n, 1);
    }
    return map;
}