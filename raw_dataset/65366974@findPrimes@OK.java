// Sieve of eratosthenes
static int[] findPrimes(int n) {
    boolean[] isPrime = new boolean[n + 1];
    ArrayList<Integer> a = new ArrayList<>();
    int[] result;
    Arrays.fill(isPrime, true);
    isPrime[0] = false;
    isPrime[1] = false;
    for (int i = 2; i * i <= n; ++i) if (isPrime[i] == true)
        for (int j = i * i; j <= n; j += i) isPrime[j] = false;
    for (int i = 0; i <= n; i++) if (isPrime[i] == true)
        a.add(i);
    result = new int[a.size()];
    for (int i = 0; i < a.size(); i++) result[i] = a.get(i);
    return result;
}