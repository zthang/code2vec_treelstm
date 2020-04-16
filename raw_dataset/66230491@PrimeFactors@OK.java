private ArrayList<Integer> PrimeFactors(int n) {
    ArrayList<Integer> primes = new ArrayList<>();
    int i = 2;
    while (i * i <= n) {
        if (n % i == 0) {
            primes.add(i);
            while (n % i == 0) {
                n /= i;
            }
        }
        i++;
    }
    if (n > 1) {
        primes.add(n);
    }
    return primes;
}