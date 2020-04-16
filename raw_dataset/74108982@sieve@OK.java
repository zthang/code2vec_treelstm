public static ArrayList<Integer> sieve(int n) {
    long sqr = (long) Math.sqrt(n);
    boolean[] isPrime = new boolean[n + 1];
    for (int i = 0; i <= n; i++) {
        isPrime[i] = true;
    }
    for (int i = 2; i <= sqr; i++) {
        if (isPrime[i]) {
            for (int p = i * i; p <= n; p += i) {
                isPrime[p] = false;
            }
        }
    }
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i <= n; i++) {
        if (isPrime[i]) {
            list.add(i);
        }
    }
    list.remove(0);
    list.remove(0);
    return list;
}