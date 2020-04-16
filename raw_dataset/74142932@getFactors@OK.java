public static ArrayList<Integer> getFactors(ArrayList<F> pfact) {
    ArrayList<Integer> factors = new ArrayList<>();
    factors.add(1);
    for (F f : pfact) {
        int[] powers = new int[f.count + 1];
        powers[0] = 1;
        for (int i = 1; i <= f.count; i++) {
            powers[i] = powers[i - 1] * f.prime;
        }
        int fsize = factors.size();
        for (int i = 0; i < fsize; i++) {
            for (int j = 1; j <= f.count; j++) {
                factors.add(factors.get(i) * powers[j]);
            }
        }
    }
    return factors;
}