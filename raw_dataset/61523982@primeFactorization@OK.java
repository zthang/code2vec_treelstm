public static HashSet<Integer> primeFactorization(int n) {
    HashSet<Integer> a = new HashSet<Integer>();
    for (int i = 2; i * i <= n; i++) {
        while (n % i == 0) {
            a.add(i);
            n /= i;
        }
    }
    if (n != 1)
        a.add(n);
    return a;
}