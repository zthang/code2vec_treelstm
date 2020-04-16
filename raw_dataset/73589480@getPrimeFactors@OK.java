List<Integer> getPrimeFactors(int x) {
    List<Integer> factors = new ArrayList<>();
    while (x > 1) {
        int fac = factor[x];
        int cnt = 0;
        while (x % fac == 0) {
            x /= fac;
            cnt++;
        }
        if (cnt % 2 == 1) {
            factors.add(fac);
        }
    }
    return factors;
}