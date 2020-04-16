Vector<Integer> sieveOfEratosthenes(int n) {
    boolean[] prime = new boolean[n + 1];
    for (int i = 0; i < n; i++) {
        prime[i] = true;
    }
    for (int p = 2; p * p <= n; p++) {
        if (prime[p] == true) {
            for (int j = p * p; j <= n; j += p) {
                prime[j] = false;
            }
        }
    }
    Vector<Integer> v = new Vector<>();
    for (int i = 2; i <= n; i++) {
        if (prime[i]) {
            v.add(i);
        }
    }
    return v;
}