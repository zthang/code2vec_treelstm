static ArrayList<Integer> sieveOfEratosthenes(int n) {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    boolean[] prime = new boolean[n + 1];
    for (int i = 2; i < n; i++) prime[i] = true;
    for (int p = 2; p * p <= n; p++) {
        if (prime[p] == true) {
            arr.add(p);
            for (int i = p * p; i <= n; i += p) prime[i] = false;
        }
    }
    return arr;
}