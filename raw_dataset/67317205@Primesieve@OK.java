public void Primesieve(int n) {
    prime = new boolean[n];
    for (int i = 0; i < n; i++) prime[i] = true;
    for (int p = 2; p * p < n; p++) {
        if (prime[p] == true) {
            for (int i = p * p; i < n; i += p) prime[i] = false;
        }
    }
}