private List<Integer> getMinFactor(int sum) {
    List<Integer> factors = new ArrayList<>();
    for (int sz = 2; sz <= sum / sz; sz++) {
        if (sum % sz == 0) {
            factors.add(sz);
            factors.add(sum / sz);
        }
    }
    if (factors.size() == 0)
        factors.add(sum);
    return factors;
}