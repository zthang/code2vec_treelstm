static void phi(int n, HashMap<Integer, Integer> hm) {
    int large = 0;
    for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) {
            if (i > large) {
                large = i;
            }
        }
        while (n % i == 0) {
            n = n / i;
        }
    }
    if (n > 1) {
        if (n > large)
            large = n;
    }
    hm.putIfAbsent(large, 0);
    hm.replace(large, hm.get(large) + 1);
}