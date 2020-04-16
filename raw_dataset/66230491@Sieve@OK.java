private ArrayList<Integer> Sieve(int n) {
    boolean[] bool = new boolean[n + 1];
    Arrays.fill(bool, true);
    bool[0] = bool[1] = false;
    for (int i = 2; i * i <= n; i++) {
        if (bool[i]) {
            int j = 2;
            while (i * j <= n) {
                bool[i * j] = false;
                j++;
            }
        }
    }
    ArrayList<Integer> primes = new ArrayList<>();
    for (int i = 2; i <= n; i++) {
        if (bool[i])
            primes.add(i);
    }
    return primes;
}