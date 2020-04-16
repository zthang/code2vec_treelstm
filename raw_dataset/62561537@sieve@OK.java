static ArrayList<Integer> sieve(int n) {
    boolean[] notprimes = new boolean[n];
    for (int i = 2; i * i <= n; i++) {
        for (int j = i * i; j <= n && !notprimes[i]; j += i) {
            notprimes[j] = true;
        }
    }
    ArrayList<Integer> ret = new ArrayList<>();
    for (int i = 2; i < notprimes.length; i++) if (!notprimes[i])
        ret.add(i);
    return ret;
}