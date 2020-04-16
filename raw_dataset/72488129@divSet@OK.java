static HashSet<Integer> divSet(int n) {
    HashSet<Integer> div = new HashSet<Integer>();
    for (int i = 1; i * i <= n; i++) {
        if (n % i == 0) {
            div.add(i);
            div.add((int) (n / i));
        }
    }
    return div;
}